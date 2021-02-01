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

    List<Orders> getByQuery(String supplierId,Integer orderId,String goodsName,String contactName,String state,String userName,Integer current,Integer size);

    int getQueryCount(String supplierId,Integer orderId,String goodsName,String contactName,String state,String userName);

    int update(Orders orders);

    Orders getById(Integer id);

    int deleteByid(Integer id);
}
