package com.travel.laizheli.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.entity.result.GoodsTop;

import java.util.List;

/**
 * @ClassName: GoodsService
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/26 21:01
 * @Version: 1.0
 **/
public interface GoodsService {

    int getCount(String supplierId,String type);

    Goods getById(Integer goodsId);

    IPage<Goods> getListByQuery(Integer current, Integer size, String goodsId, String supplierId, String name, String state, String type);

    int updateState(Goods goods);

    int delete(Integer goodsId);

    int addGoods(Goods goods);

    int updateGoods(Goods goods);

    List<GoodsTop> getTop();
}
