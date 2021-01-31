package com.travel.laizheli.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.laizheli.dto.GoodsList;
import com.travel.laizheli.entity.Goods;

import java.util.List;

/**
 * 旅游商品service类
 * 此处写service接口，具体内容在相应的Impl类中实现
 * create by chen on 2021/1/21
 */

public interface IGoodsService {
    IPage<GoodsList> getGoodsList(Integer current, Integer size, String type);
    Goods getGoodsDetail(Integer id);
    List<Goods> getGoodsList();
}
