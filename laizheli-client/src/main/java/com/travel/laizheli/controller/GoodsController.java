package com.travel.laizheli.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.laizheli.dto.GoodsList;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.service.IGoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 旅游商品controller类
 * create by chen on 2021/1/21
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private IGoodsService goodsService;


    @GetMapping("/hot")
    public Result<List<Goods>> getHotGoods(){
        List<Goods> list = goodsService.getGoodsList();
        return Result.success(list);
    };

    @PostMapping("/list")
    public Result<IPage<GoodsList>> goodsList(@RequestParam(value = "pageNum", defaultValue = "1") Integer current,
                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer size,
                                          @RequestParam(value = "type") String type){
        IPage<GoodsList> page = goodsService.getGoodsList(current, size, type);
        return Result.success(page);
    }

    @PostMapping("/detail")
    public Result<Goods> getGoodDetail(@RequestParam(value = "id") Integer id){

        return Result.failed();
    }
}
