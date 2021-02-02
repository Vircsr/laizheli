package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.laizheli.entity.Comment;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.mapper.CommentMapper;
import com.travel.laizheli.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: CommentServiceImpl
 * @Description: 评价服务层实现类
 * @Author: Wangcb
 * @Date: 2021/2/2 11:29
 * @Version: 1.0
 **/
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    /**
     * @Description: 根据商品ID查询评论总数
     * @Param: goodsId 
    **/        
    @Override
    public int getCount(Integer goodsId) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_id",goodsId);
        return commentMapper.selectCount(queryWrapper);
    }

    /**
     * @Description: 根据查询条件查询某一商品的评价列表
     * @Param: goodsId
     * @Param: userName
     * @Param: content  评价内容
    **/
    @Override
    public List<Comment> getList(Integer goodsId, String userName, String content, Integer startIndex, Integer size) {
        return commentMapper.getList(goodsId,userName,content,startIndex,size);
    }

    /**
     * @Description: 根据查询条件得到评价列表总数
     * @Param: goodsId
     * @Param: userName
     * @Param: content 
    **/        
    @Override
    public int getCountByQuery(Integer goodsId, String userName, String content) {
        return commentMapper.getCountByQuery(goodsId,userName,content);
    }
}
