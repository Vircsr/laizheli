package com.travel.laizheli.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.protocol.x.ReusableInputStream;
import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.entity.Qualification;
import com.travel.laizheli.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yh
 * @Description:
 * @Date: Created in 2021/3/2 10:17
 * @Version：
 */
@RestController
@RequestMapping("goods")
@Slf4j
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    @GetMapping("/all")
    public Result getGoods(@RequestParam("current")Integer current,
                           @RequestParam("size")Integer size,
                           @RequestParam("state")String state,
                           @RequestParam("goodsId")String goodsId,
                           @RequestParam("name")String name){
        IPage<Goods> listByQuery = goodsService.getListByQuery(current, size,name,state,goodsId);
        return Result.success(listByQuery,"成功获取商品列表");
    }

    /**
     * @Description: 获取商品的总数
     * @Param: supplierId
     **/
    @PostMapping("/getCount")
    public Result getCount(){

        // 获取商品数量
        int count = goodsService.getCount();


        return Result.success(count,"商品数量获取成功");
    }
    /**
     * @Description: 删除商品
     * @Param: goodsId
     **/
    @GetMapping("/delete")
    public Result delete(@RequestParam("goodsId")Integer goodsId){
        if (goodsId==null){
            return Result.failed("获取商品ID失败");
        }
        int result = goodsService.delete(goodsId);
        if (result==1){
            return Result.success(null,"成功删除商品");
        }else {
            return Result.failed("删除商品失败");
        }
    }

    /**
     * @Description: 更新商品状态
     * @Param: goodsId
     * @Param: state 
    **/
    @PostMapping("/update")
    public Result updateState(@RequestParam("goodsId")Integer goodsId,
                              @RequestParam("state")String state){
        if (goodsId==null){
            return Result.failed("获取商品ID失败");
        }
        Goods goods = goodsService.findById(goodsId);
        if(goods == null){
            return Result.failed("商品ID无效");
        }
        goods.setState(state);
        int result = goodsService.updateState(goods);
        if(result != 1){
            return Result.failed("更新失败");
        }
        return Result.success(null,"更新成功");

    }

}
