package com.travel.laizheli.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.laizheli.dao.OrderDao;
import com.travel.laizheli.entity.Orders;
import com.travel.laizheli.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: OrderServiceImpl
 * @Description: 订单服务实现类
 * @Author: yh
 * @Date: 2021/1/26 21:57
 * @Version: 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    /**
     * @Description: 根据供应商ID获取商品数量
     * @Param: supplierId
    **/
    @Override
    public int getCount() {
//        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("order_id",orderId);
        return orderDao.selectCount(null);
    }
    @Override
    public int getTotalPrice() {
        return orderDao.getTotalPrice();
    }

    /**
     * @Description: 根据供应商ID和商品类型获取商品
     * @Param: supplierId
     * @Param: type
    **/
//    @Override
//    public List<Orders> getByIdType(String supplierId, String type) {
//        return orderDao.getByIdType(supplierId,type);
//    }

    /**
     * @Description: 根据查询条件查询订单列表
     * @Param: supplierId
     * @Param: orderId
     * @Param: goodsName
     * @Param: contactName
     * @Param: state 
    **/        
    @Override
    public List<Orders> getByQuery(Integer orderId, String goodsName, String supplierName, String contactName, String state, String userName, Integer startIndex, Integer size) {

        return orderDao.getByQuery(orderId,goodsName,supplierName,contactName,state,userName,startIndex,size);
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
    public int getQueryCount(Integer orderId, String goodsName, String contactName, String state,String userName) {
        return orderDao.getQueryCount(orderId, goodsName, contactName,state,userName);
    }

//    @Override
//    public List<Orders> getAll() {
//        return orderDao.selectList(null);
//    }



}
