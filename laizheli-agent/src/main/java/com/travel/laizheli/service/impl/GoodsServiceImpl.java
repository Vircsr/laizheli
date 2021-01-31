package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.mapper.GoodsMapper;
import com.travel.laizheli.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: GoodsServiceImpl
 * @Description: 商品服务类
 * @Author: Wangcb
 * @Date: 2021/1/26 21:05
 * @Version: 1.0
 **/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;


    /**
     * @Description: 获取全部商品
    * @Param: supplierId
    **/
    @Override
    public List<Goods> getList(String supplierId) {
        return null;
    }

    /**
     * @Description: 根据商品类型获取商品列表
     * @Param: supplierId
     * @Param: type
    **/
    @Override
    public List<Goods> getByType(String supplierId, String type) {
        return null;
    }

    /**
     * @Description: 根据商品ID获取商品
     * @Param: supplierId
     * @Param: id
    **/
    @Override
    public Goods getById(String supplierId, Integer id) {
        return null;
    }

    /**
     * @Description: 获取商品总数
     * @Param: supplierId
     * @Param: type 
    **/        
    @Override
    public int getCount(String supplierId, String type) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("supplier_id",supplierId);
        queryWrapper.eq("type",type);
        return goodsMapper.selectCount(queryWrapper);
    }
}
