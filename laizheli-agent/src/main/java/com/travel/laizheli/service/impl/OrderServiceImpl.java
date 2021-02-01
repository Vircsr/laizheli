package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.laizheli.entity.Orders;
import com.travel.laizheli.mapper.OrderMappper;
import com.travel.laizheli.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * @Description: 根据供应商ID获取商品数量
     * @Param: supplierId
    **/
    @Override
    public int getCount(String supplierId) {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("supplier_id",supplierId);
        return orderMappper.selectCount(queryWrapper);
    }

    /**
     * @Description: 根据供应商ID和商品类型获取商品
     * @Param: supplierId
     * @Param: type
    **/
    @Override
    public List<Orders> getByIdType(String supplierId, String type) {
        return orderMappper.getByIdType(supplierId,type);
    }

    /**
     * @Description: 根据查询条件查询订单列表
     * @Param: supplierId
     * @Param: orderId
     * @Param: goodsName
     * @Param: contactName
     * @Param: state 
    **/        
    @Override
    public List<Orders> getByQuery(String supplierId, Integer orderId, String goodsName, String contactName, String state,String userName,Integer startIndex,Integer size) {

        return orderMappper.getByQuery(supplierId,orderId,goodsName,contactName,state,userName,startIndex,size);
    }

    /**
     * @Description: 根据查询条件查到的列表长度
     * @Param: supplierId
     * @Param: orderId
     * @Param: goodsName
     * @Param: contactName
     * @Param: state
    **/
    @Override
    public int getQueryCount(String supplierId, Integer orderId, String goodsName, String contactName, String state,String userName) {
        return orderMappper.getQueryCount(supplierId, orderId, goodsName, contactName,state,userName);
    }

    /**
     * @Description: 更新订单信息
     * @Param: orders 
    **/        
    @Override
    public int update(Orders orders) {
        return orderMappper.updateById(orders);
    }

    /**
     * @Description: 根据ID获取订单
     * @Param: id
    **/
    @Override
    public Orders getById(Integer id) {
        return orderMappper.selectById(id);
    }

    /**
     * @Description: 删除订单
     * @Param: id
    **/
    @Override
    public int deleteByid(Integer id) {
        return orderMappper.deleteById(id);
    }

}
