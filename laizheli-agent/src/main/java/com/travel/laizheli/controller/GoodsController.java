package com.travel.laizheli.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.entity.Scheduling;
import com.travel.laizheli.service.GoodsService;
import com.travel.laizheli.util.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
@Slf4j
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

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
                                 @RequestParam("current")Integer current,
                                 @RequestParam("size")Integer size,
                                 @RequestParam("name")String name,
                                 @RequestParam("state")String state){
        if (supplierId.length()<=0){
            return Result.validateFailed("获取供应商ID失败");
        }
        IPage<Goods> listByQuery = goodsService.getListByQuery(current, size, goodsId, supplierId, name, state);
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
        String filename = FileUploadUtil.uploadFile(multipartFile);
        return Result.success(filename,"图片上传成功");
    }

    @PostMapping("/add")
    public Result addGoods(@RequestBody Goods goods){
        if (goods == null) {
            return Result.validateFailed("商品信息为空");
        }
        log.info("收到的商品为："+goods);
        // 设置商品其他属性
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
    
}
