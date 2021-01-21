package com.travel.laizheli.controller;

import com.travel.laizheli.Entity.Goods;
import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 旅游商品controller类
 * create by chen on 2021/1/21
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @GetMapping("/hot")
    public Result<List<Goods>> getHotGoods(){
        return Result.failed();
    };
}
