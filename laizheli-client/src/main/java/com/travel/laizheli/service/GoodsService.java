package com.travel.laizheli.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.laizheli.Entity.Goods;

/**
 * TODO
 * create by chen on 2021/1/21
 */

public interface GoodsService {
    public IPage<Goods> getHotGoods();
}
