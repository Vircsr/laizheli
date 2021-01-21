package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.laizheli.Entity.Goods;
import com.travel.laizheli.service.GoodsService;
import org.springframework.stereotype.Service;

/**
 * goods service 实现类
 * create by chen on 2021/1/21
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Override
    public IPage<Goods> getHotGoods() {
        return null;
    }
}
