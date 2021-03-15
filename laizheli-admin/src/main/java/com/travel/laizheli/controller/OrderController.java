package com.travel.laizheli.controller;

import com.travel.laizheli.entity.Orders;
import com.travel.laizheli.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import com.travel.laizheli.common.api.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yh
 * @Description:
 * @Date: Created in 2021/3/2 15:32
 * @Version：
 */
@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

//    @GetMapping("/all")
//    public Result getOrders(){
//        List<Orders> orders = orderService.getAll();
//        if (orders == null){
//            return Result.failed("找不到订单");
//        }
//        return Result.success(orders,"成功获取订单");
//    }
    /**
     * @Description: 根据供应商ID获取订单总量
     * @Param: supplierId
     **/
    @GetMapping("/count")
    public Result getCount(){
//        if (orderId.length()<=0){
//            return Result.validateFailed("订单数量获取失败");
//        }
        int orderCount = orderService.getCount();
        return Result.success(orderCount,"成功获取订单总量");
    }

    @GetMapping("/price")
    public Result getTotalPrice(){

        int total = orderService.getTotalPrice();
        return Result.success(total,"成功获取成交总量");
    }


    /**
     * @Description: 根据查询条件查询订单列表
     * @Param: supplierId
     * @Param: orderId
     * @Param: goodsName
     * @Param: contactName
     * @Param: state
     * @Param: userName
     * @Param: current
     * @Param: size
     **/
    @GetMapping("/get")
    public Result getByQuery(//@RequestParam("supplierId")String supplierId,
                             @RequestParam("orderId")String orderId,
                             @RequestParam("goodsName")String goodsName,
                             @RequestParam("supplierName") String supplierName,
                             @RequestParam("contactName")String contactName,
                             @RequestParam("state")String state,
                             @RequestParam("userName")String userName,
                             @RequestParam("current")Integer current,
                             @RequestParam("size")Integer size
    ){

        Integer order;
        Integer startIndex = (current-1)*size;
        if (orderId==null || orderId==""){
            order =null;
        }else {
            order = Integer.parseInt(orderId);
        }
        // 获取查询结果列表
        List<Orders> ordersList = orderService.getByQuery(order, goodsName, supplierName,contactName, state, userName, startIndex, size);
        // 获取查询结果长度
        int count = orderService.getQueryCount(order,goodsName,contactName,state,userName);
        if (ordersList != null) {
            Map<String,Object> map = new HashMap<>();
            map.put("data",ordersList);
            map.put("total",count);
            return Result.success(map,"成功获取订单列表");
        }else {
            return Result.failed("获取订单列表失败");
        }
    }
}
