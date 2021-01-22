package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.mapper.GoodsMapper;
import com.travel.laizheli.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * goods service 实现类
 * create by chen on 2021/1/21
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    GoodsMapper goodsMapper;
    @Override
    public IPage<Goods> getGoodsList(Integer current, Integer size, String type) {
//      条件构造器
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",type);
//        分页设置
        Page<Goods> page = new Page<>(current,size);
        return goodsMapper.selectPage(page,queryWrapper);
    }
}
