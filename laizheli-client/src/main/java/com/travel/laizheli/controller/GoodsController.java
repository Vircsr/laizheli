package com.travel.laizheli.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.laizheli.Entity.Goods;
import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.util.List;

/**
 * 旅游商品controller类
 * create by chen on 2021/1/21
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;


    @GetMapping("/hot")
    public Result<List<Goods>> getHotGoods(){
        return Result.failed();
    };

    @PostMapping("/list")
    public Result<IPage<Goods>> goodsList(@RequestParam(value = "pageNum", defaultValue = "1") Integer current,
                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer size,
                                          @RequestParam(value = "type") String type){
        IPage<Goods> page = goodsService.getGoodsList(current, size, type);
        return Result.success(page);
    }
}
