package com.travel.laizheli.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.dto.NoticeInfo;
import com.travel.laizheli.entity.Orders;
import com.travel.laizheli.service.IOrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 查询属于该用户的所有订单信息
     * @param userId
     * @return
     */
    @GetMapping("/orders/{userId}")
    public Result getOrdersByuserIdAnd(Page<Orders> page, @PathVariable String userId,
                                       @RequestParam(defaultValue = "0") int state) {
        page.setSize(30);
        QueryWrapper queryWrapper = new QueryWrapper();
        Map map = new HashMap();
        map.put("user_id", userId);
        // 如果状态不为0，那么就查找对应状态，否则查找所有状态
        if (state != 0) {
            map.put("state", state);
        }
        queryWrapper.allEq(map);
        Page<Orders> ordersPage = ordersService.page(page, queryWrapper);

        log.info(ordersPage.toString());
        if (ordersPage != null) {
            return Result.success(ordersPage);
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

        if (orderById != null) {
            return Result.success(orderById);
        } else {
            return Result.failed();
        }
    }


    /**
     * 修改联系人，因为参数联系人中已经包含了id信息了，所以无需id
     * @param id
     * @param state
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
        return ordersService.selectNoticeList(userId,now,aWeek);
    }

}
