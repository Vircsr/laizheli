package com.travel.laizheli.service;

import com.travel.laizheli.entity.Goods;

import java.util.List;

/**
 * @ClassName: GoodsService
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/26 21:01
 * @Version: 1.0
 **/
public interface GoodsService {

    List<Goods> getList(String suppilerId);

    List<Goods> getByType(String supplierId,String type);

    Goods getById(String supplierId,Integer id);

    int getCount(String supplierId,String type);
}
