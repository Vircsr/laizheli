package com.travel.laizheli.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.laizheli.dto.GoodsList;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.service.IGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 旅游商品controller类
 * create by chen on 2021/1/21
 */
@RestController
@Slf4j
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private IGoodsService goodsService;

    @Autowired
    private RedisTemplate redisTemplate;

//    @GetMapping("/hot")
//    public Result<List<Goods>> getHotGoods(){
//        List<Goods> list = goodsService.getGoodsList();
//        return Result.success(list);
//    };


    @GetMapping("/hot")
    public Result<List<Goods>> getHotGoods(){
        ListOperations listOperations = redisTemplate.opsForList();
        Boolean hotspot = redisTemplate.hasKey("hotlist");
        List<Goods> list = null;
        // 如果存在
        if (hotspot){
            // 直接从redis获取
            list = listOperations.range("hotlist", 0, -1);
            log.info("redis中有数据，直接从redis获取");
            // goodsTopList.forEach(item -> System.out.println(item.getId()+item.getName()+item.getCount()));
        }else {
            log.info("redis中没有数据，重新获取并写入redis，过期时间为1分钟");
            list = goodsService.getGoodsList();
            listOperations.rightPushAll("hotlist",list) ;
            listOperations.getOperations().boundListOps("hotlist").expire(1, TimeUnit.MINUTES);
        }
        return Result.success(list,"成功获取top5");
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
        return Result.success(goodsService.getGoodsDetail(id));
    }
}
