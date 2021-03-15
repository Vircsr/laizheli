package com.travel.laizheli.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.entity.Qualification;

import java.util.List;

/**
 * @Author: yh
 * @Description:
 * @Date: Created in 2021/3/2 10:13
 * @Version：
 */
public interface GoodsService {
    //public IPage<Goods> getPage(Integer current, Integer size);
//    List<Goods> getAll();
    int getCount();

    IPage<Goods> getListByQuery(Integer current, Integer size,String name,String state,String goodsId);
    //IPage<Goods> getListByQuery(Integer current, Integer size, String goodsId, String supplierId, String name, String state, String type);

    int delete(Integer goodsId);
}
