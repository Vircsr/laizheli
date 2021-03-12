package com.travel.laizheli.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.Comment;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.entity.Scheduling;
import com.travel.laizheli.entity.result.GoodsTop;
import com.travel.laizheli.service.CommentService;
import com.travel.laizheli.service.GoodsService;
import com.travel.laizheli.util.AliyunOSSUtil;
import com.travel.laizheli.util.FileUploadUtil;
import javafx.beans.binding.ObjectExpression;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: GoodsController
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/26 21:10
 * @Version: 1.0
 **/
@RestController
@RequestMapping("goods")
@Slf4j
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @Description: 获取各类商品的总数
     * @Param: supplierId   
    **/        
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
        return Result.success(listCount,"商品数量获取成功");
    }

    /**
     * @Description: 根据查询条件查询商品列表
     * @Param: supplierId
     * @Param: goodsId
     * @Param: current
     * @Param: size
     * @Param: name
     * @Param: state 
    **/        
    @GetMapping("/query")
    public Result getListByQuery(@RequestParam("supplierId")String supplierId,
                                 @RequestParam("goodsId")String goodsId,
                                 @RequestParam("type")String type,
                                 @RequestParam("current")Integer current,
                                 @RequestParam("size")Integer size,
                                 @RequestParam("name")String name,
                                 @RequestParam("state")String state){
        if (supplierId.length()<=0){
            return Result.validateFailed("获取供应商ID失败");
        }
        IPage<Goods> listByQuery = goodsService.getListByQuery(current, size, goodsId, supplierId, name, state, type);
        return Result.success(listByQuery,"成功获取商品列表");
    }

    /**
     * @Description: 查询商品列表，商品中包含了商品评论数量comments
     * @Param: supplierId
     * @Param: goodsId
     * @Param: current
     * @Param: size
     * @Param: name
     **/
    @GetMapping("/queryc")
    public Result getGoodsComments(@RequestParam("supplierId")String supplierId,
                                   @RequestParam("goodsId")String goodsId,
                                   @RequestParam("current")Integer current,
                                   @RequestParam("size")Integer size,
                                   @RequestParam("name")String name){
        if (supplierId.length()<=0){
            return Result.validateFailed("获取供应商ID失败");
        }
        IPage<Goods> listByQuery = goodsService.getListByQuery(current, size, goodsId, supplierId, name, null, null);
        if (listByQuery != null) {
            for (Goods record : listByQuery.getRecords()) {
                record.setComments(commentService.getCount(record.getId()));
            }
        }
        return Result.success(listByQuery,"成功获取商品列表");
    }

    /**
     * @Description: 更新商品状态: 发布、下架
     * @Param: goodsId
     * @Param: state 
    **/        
    @GetMapping("/state")
    public Result updateState(@RequestParam("goodsId")Integer goodsId,
                              @RequestParam("state")String state){
        if (goodsId==null){
            return Result.failed("获取商品ID或者状态值失败");
        }
        Goods goods = goodsService.getById(goodsId);
        goods.setState(state);
        int result = goodsService.updateState(goods);
        if (result==1){
            return Result.success(null,"成功更新商品状态");
        }else {
            return Result.failed("更新商品状态失败");
        }
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
     * @Description: 上传商品图片
     * @Param: multipartFile
    **/
    @PostMapping("/upload")
    public Result upload(@RequestParam("upload")MultipartFile multipartFile) throws IOException {
        if (multipartFile==null){
            return Result.validateFailed("获取文件错误,请重新选择文件");
        }
        //上传图片
        String fileUrl = AliyunOSSUtil.upload(multipartFile, "goods");
        if (fileUrl ==null){
            return Result.failed("上传失败");
        }
        return Result.success(fileUrl,"图片上传成功");
    }

    /**
     * @Description: 添加商品
     * @Param: goods 
    **/        
    @PostMapping("/add")
    public Result addGoods(@RequestBody Goods goods){
        if (goods == null) {
            return Result.validateFailed("商品信息为空");
        }
        log.info("收到的商品为："+goods);
        // 初始化商品其他属性
        goods.setScore(0.0);
        goods.setState("1");
        goods.setSold(0);
        goods.setVisits(0);

        // 插入商品
        int result = goodsService.addGoods(goods);
        if (result == 1 && goods.getId() != null){
            return Result.success(goods.getId(),"商品添加成功");
        }else {
            return Result.failed("商品添加失败");
        }
    }

    /**
     * @Description: 更新商品信息
     * @Param: goods 
    **/        
    @PostMapping("/update")
    public Result updateGoods(@RequestBody Goods goods){
        if (goods == null) {
            return Result.validateFailed("商品信息为空");
        }
        int result = goodsService.updateGoods(goods);
        if (result == 1){
            return Result.success(null,"成功更新商品信息");
        }else {
            return Result.failed("更新商品信息失败");
        }
    }

    /**
     * @Description: 获取热门景点top5
    **/
    @GetMapping("/hotspot")
    public Result hotspot(){
        ListOperations listOperations = redisTemplate.opsForList();
        Boolean hotspot = redisTemplate.hasKey("hotspot");
        List<GoodsTop> goodsTopList;
        // 如果存在
        if (hotspot){
            // 直接从redis获取
            goodsTopList = listOperations.range("hotspot", 0, -1);
            log.info("redis中有数据，直接从redis获取");
            // goodsTopList.forEach(item -> System.out.println(item.getId()+item.getName()+item.getCount()));
        }else {
            log.info("redis中没有数据，重新获取并写入redis，过期时间为1分钟");
            goodsTopList =  goodsService.getTop();
            listOperations.rightPushAll("hotspot",goodsTopList) ;
            listOperations.getOperations().boundListOps("hotspot").expire(1, TimeUnit.MINUTES);
        }
        return Result.success(goodsTopList,"成功获取top5");
    }



    
}
