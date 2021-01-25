package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.laizheli.dto.GoodsList;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.mapper.GoodsMapper;
import com.travel.laizheli.service.IGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * goods service 实现类
 * create by chen on 2021/1/21
 */
@Service
public class GoodsService implements IGoodsService {
    @Resource
    GoodsMapper goodsMapper;
    @Override
    public IPage<GoodsList> getGoodsList(Integer current, Integer size, String type) {
//      条件构造器
        QueryWrapper<GoodsList> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",type).eq("state","3");
//        分页设置
        Page<GoodsList> page = new Page<>(current,size);
        return goodsMapper.selectGoodsPage(page,type);
    }

    @Override
    public Goods getGoodsDetail(Integer id) {
//        之后添加多表联合查询
        return goodsMapper.selectById(id);
    }

    /**
     * 热门旅游项目，按照visits倒序查询
     * @return List
     */
    @Override
    public List<Goods> getGoodsList() {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("visits");
        Page<Goods> page = new Page<>(1,5);
        return goodsMapper.selectPage(page,queryWrapper).getRecords();
    }
}
