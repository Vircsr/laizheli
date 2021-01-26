package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.laizheli.entity.Orders;
import com.travel.laizheli.mapper.OrderMappper;
import com.travel.laizheli.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: OrderServiceImpl
 * @Description: 订单服务实现类
 * @Author: Wangcb
 * @Date: 2021/1/26 21:57
 * @Version: 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMappper orderMappper;

    @Override
    public int getCount(String supplierId) {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("supplier_id",supplierId);
        return orderMappper.selectCount(queryWrapper);
    }
}
