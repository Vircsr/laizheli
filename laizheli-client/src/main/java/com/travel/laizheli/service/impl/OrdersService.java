package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.travel.laizheli.entity.Orders;
import com.travel.laizheli.mapper.OrdersMapper;
import com.travel.laizheli.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nemo
 * @date 2021/1/27
 */
@Service
public class OrdersService extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    @Autowired
    private OrdersMapper ordersMapper;


}
