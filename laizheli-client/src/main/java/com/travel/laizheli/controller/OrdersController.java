package com.travel.laizheli.controller;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.dto.NoticeInfo;
import com.travel.laizheli.dto.OrderListDto;
import com.travel.laizheli.entity.Collection;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.entity.Orders;
import com.travel.laizheli.entity.Supplier;
import com.travel.laizheli.service.IGoodsService;
import com.travel.laizheli.service.IOrdersService;
import com.travel.laizheli.service.ISupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;


/**
 * @author Nemo
 * @date 2021/1/27
 */
@RestController
@RequestMapping("orders")
@Slf4j
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private ISupplierService supplierService;

    /**
     * 查询属于该用户的所有订单信息
     * @param userId
     * @return
     */
    @GetMapping("/orders/{userId}")
    public Result getOrdersByUserIdAndState(Page<Orders> page, @PathVariable String userId,
                                       @RequestParam(defaultValue = "0") int state) {
        // 特别注意：这里没有使用分页，到时候全写完再加好了
        page.setSize(30);
//        Page<OrderDto> orderDtoPage = new Page<>();
        List<OrderListDto> orderListDtos = new ArrayList<>();

        QueryWrapper queryWrapper = new QueryWrapper();
        Map map = new HashMap();
        map.put("user_id", userId);
        // 如果状态不为0，那么就查找对应状态，否则查找所有状态
        if (state != 0) {
            map.put("state", state);
        }
        queryWrapper.allEq(map);
        queryWrapper.orderByDesc("create_time");
        // 1. 找到对应的订单
        Page<Orders> ordersPage = ordersService.page(page, queryWrapper);
        ordersPage.getRecords().forEach(orders -> {
            // 2. 通过订单中的商品id找到对应的商品信息
            long goodsId = orders.getGoodsId();
            Integer goodsIdInteger = new Integer((int)goodsId);
            Goods goodsDetail = goodsService.getGoodsDetail(goodsIdInteger);

            // 3. 通过订单中的供应商id找到对应的供应商名称
            String supplierId = orders.getSupplierId();
            Supplier supplierById = supplierService.getById(supplierId);
            String supplierByIdName = supplierById.getName();

            // 组合
            OrderListDto orderListDto = new OrderListDto(orders, goodsDetail, supplierByIdName);
            orderListDtos.add(orderListDto);
        });

//        orderDtoPage.setRecords(orderDtos);

//        log.info("-------------------传输信息：" + orderDtoPage.getRecords().toString());
        if (orderListDtos != null) {
            orderListDtos.forEach(System.out::println);

            // 倒序
//            Collections.reverse(orderListDtos);
            return Result.success(orderListDtos);
        } else {
            return Result.failed();
        }
    }


    /**
     * 通过id删除订单
     * @param id 订单id
     * @return
     */
    @Transactional
    @DeleteMapping("/order/{id}")
    public Result delOrderById(@PathVariable long id) {

        boolean removeById = ordersService.removeById(id);
        if (removeById) {
            return Result.success(null);
        } else {
            return Result.failed();
        }
    }


    /**
     * 通过订单id找到订单信息
     * @param id 订单id
     * @return
     */
    @GetMapping("/order/{id}")
    public Result getOrderById(@PathVariable long id) {

        Orders orderById = ordersService.getById(id);

        // 2. 通过订单中的商品id找到对应的商品信息
        long goodsId = orderById.getGoodsId();
        Integer goodsIdInteger = new Integer((int)goodsId);
        Goods goodsDetail = goodsService.getGoodsDetail(goodsIdInteger);

        // 3. 通过订单中的供应商id找到对应的供应商名称
        String supplierId = orderById.getSupplierId();
        Supplier supplierById = supplierService.getById(supplierId);
        String supplierByIdName = supplierById.getName();

        // 组合
        OrderListDto orderListDto = new OrderListDto(orderById, goodsDetail, supplierByIdName);

        if (orderListDto != null) {
            return Result.success(orderListDto);
        } else {
            return Result.failed();
        }
    }


    /**
     * 修改订单状态：
     * @param id
     * @param state 订单状态：1待付款，2待接单，3待出行，4已出行，5退款中，6已退款，7已取消
     * @return
     */
    @PutMapping("/order/{id}/{state}")
    public Result updateContact(@PathVariable long id, @PathVariable int state) {

        Orders orders = ordersService.getById(id);
        orders.setState(state);
        boolean updateById = ordersService.updateById(orders);

        if (updateById) {
            log.info("修改订单状态：" + orders.toString());
            return Result.success(null);
        } else {
            return Result.failed();
        }
    }

    @PostMapping("/order/{userId}/{goodsId}/{supplierId}")
    public Result addOrder(@PathVariable String userId, @PathVariable long goodsId, @PathVariable String supplierId, @RequestBody Orders order) {

        order.setUserId(userId);
        order.setGoodsId(goodsId);
        order.setSupplierId(supplierId);

        // 设置创建时间
        order.setCreateTime(DateTime.now());

        // 设置折扣
        order.setDiscount(new BigDecimal(0));



        boolean save = ordersService.save(order);
        if (save) {
            return Result.success(null);
        } else {
            return Result.failed();
        }
    }


    /**
     * 消息提醒，获取前一周内出发的日期
     * @param userId
     * @return
     */
    @PostMapping("/notice")
    public List<Orders> getNotice(@RequestParam(value = "id") String userId){
        Date now = new Date();
        Calendar ca = Calendar.getInstance();
        ca.setTime(now);
        ca.add(Calendar.DATE,7);
        Date aWeek = ca.getTime();
        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId).between("start_date",now,aWeek);
        wrapper.orderByDesc("create_time");
        return ordersService.getBaseMapper().selectList(wrapper);
    }
    /**
     * 消息提醒，获取前一周内出发的日期
     * @param userId
     * @return
     */
    @PostMapping("/notice/count")
    public Integer getNoticeCount(@RequestParam(value = "id") String userId){
        Date now = new Date();
        Calendar ca = Calendar.getInstance();
        ca.setTime(now);
        ca.add(Calendar.DATE,7);
        Date aWeek = ca.getTime();
        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId).between("start_date",now,aWeek);
        return ordersService.getBaseMapper().selectCount(wrapper);
    }

    @PostMapping("/notice/list")
    public List<NoticeInfo> getNoticeList(@RequestParam(value = "id") String userId){
        Date now = new Date();
        Calendar ca = Calendar.getInstance();
        ca.setTime(now);
        ca.add(Calendar.DATE,7);
        Date aWeek = ca.getTime();

        List<NoticeInfo> noticeInfos = ordersService.selectNoticeList(userId, now, aWeek);
        Collections.reverse(noticeInfos);
        return noticeInfos;
    }

}
