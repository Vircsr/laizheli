package com.travel.laizheli.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.laizheli.entity.Goods;

/**
 * 旅游商品service类
 * 此处写service接口，具体内容在相应的Impl类中实现
 * create by chen on 2021/1/21
 */

public interface GoodsService{
    public IPage<Goods> getGoodsList(Integer current, Integer size, String type);
}
