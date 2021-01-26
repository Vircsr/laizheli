package com.travel.laizheli.controller;

import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: GoodsController
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/26 21:10
 * @Version: 1.0
 **/
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/getCount")
    public Result getCount(@RequestParam("supplierId")String supplierId){
        if (supplierId.length()<0){
            return Result.validateFailed("获取供应商ID失败");
        }
        // 获取商品数量
        int countInland = goodsService.getCount(supplierId, "1");
        int countOut = goodsService.getCount(supplierId, "3");
        int countRim = goodsService.getCount(supplierId,"2");
        int countSpecial = goodsService.getCount(supplierId,"4");
        List<Integer> listCount = new ArrayList<>();
        listCount.add(countInland);
        listCount.add(countRim);
        listCount.add(countOut);
        listCount.add(countSpecial);
        return Result.success(listCount,"商品获取成功");
    }
}
