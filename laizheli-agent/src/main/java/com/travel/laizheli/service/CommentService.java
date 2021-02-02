package com.travel.laizheli.service;

import com.travel.laizheli.entity.Comment;

import java.util.List;

/**
 * @ClassName: CommentService
 * @Description: 评价服务层
 * @Author: Wangcb
 * @Date: 2021/2/2 11:28
 * @Version: 1.0
 **/
public interface CommentService {

    int getCount(Integer goodsId);

    List<Comment> getList(Integer goodsId,String userName, String content, Integer startIndex, Integer size);

    int getCountByQuery(Integer goodsId,String userName, String content);
}
