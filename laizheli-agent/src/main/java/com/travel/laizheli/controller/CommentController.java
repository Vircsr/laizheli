package com.travel.laizheli.controller;

import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.Comment;
import com.travel.laizheli.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReactiveSubscription;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: CommentController
 * @Description: 评价控制层
 * @Author: Wangcb
 * @Date: 2021/2/2 11:35
 * @Version: 1.0
 **/
@RestController
@RequestMapping("comment")
@Slf4j
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * @Description: 根据商品ID获取商品列表
     * @Param: goodsId 
    **/        
    @GetMapping("/count")
    public Result getCount(@RequestParam("goodsId")Integer goodsId){
        if (goodsId == null){
            return Result.validateFailed("获取商品ID失败");
        }
        int count = commentService.getCount(goodsId);
        return Result.success(count,"成功获取评论总数");
    }

    @GetMapping("/get")
    public Result getByQuery(@RequestParam("goodsId")Integer goodsId,
                             @RequestParam("userName")String userName,
                             @RequestParam("content")String content,
                             @RequestParam("current")Integer current,
                             @RequestParam("size")Integer size){
        if (goodsId == null){
            return Result.validateFailed("获取商品ID失败");
        }
        Integer startIndex = (current-1)*size;
        List<Comment> commentList = commentService.getList(goodsId, userName, content, startIndex, size);
        int countByQuery = commentService.getCountByQuery(goodsId, userName, content);
        Map<String,Object> map = new HashMap<>();
        map.put("data",commentList);
        map.put("total",countByQuery);
        return Result.success(map,"成功获取评价列表");
    }
}
