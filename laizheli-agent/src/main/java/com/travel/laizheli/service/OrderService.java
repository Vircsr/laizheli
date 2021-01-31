package com.travel.laizheli.service;

import com.travel.laizheli.entity.Orders;

import java.util.List;

/**
 * @ClassName: OrderService
 * @Description: 订单服务接口
 * @Author: Wangcb
 * @Date: 2021/1/26 21:56
 * @Version: 1.0
 **/
public interface OrderService {

    int getCount(String supplierId);

    List<Orders> getByIdType(String supplierId,String type);
}
