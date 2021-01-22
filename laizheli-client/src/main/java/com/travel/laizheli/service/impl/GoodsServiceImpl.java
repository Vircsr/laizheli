package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.laizheli.Entity.Goods;
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
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",type);
        Page<Goods> page = new Page<>(current,size);
        IPage<Goods> result = goodsMapper.selectPage(page,queryWrapper);
        return result;
    }
}
