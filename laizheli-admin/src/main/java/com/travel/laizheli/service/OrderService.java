package com.travel.laizheli.service;

import com.travel.laizheli.entity.Orders;

import java.util.List;

/**
 * @ClassName: OrderService
 * @Description: 订单服务接口
 * @Author: yh
 * @Date: 2021/1/26 21:56
 * @Version: 1.0
 **/
public interface OrderService {

    int getCount();


    //List<Orders> getByIdType(String supplierId, String type);

    List<Orders> getByQuery(Integer orderId, String goodsName, String supplierName, String contactName, String state, String userName, Integer current, Integer size);

    int getQueryCount(Integer orderId,String goodsName, String contactName,String state,String userName);

    //List<Orders> getAll();
    int getTotalPrice();
}
