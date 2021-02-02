package com.travel.laizheli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travel.laizheli.entity.Comment;

import java.util.List;

/**
 * @ClassName: CommentMapper
 * @Description: 评价mapper层
 * @Author: Wangcb
 * @Date: 2021/2/2 11:25
 * @Version: 1.0
 **/
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> getList(Integer goodsId,String userName, String content, Integer startIndex, Integer size);

    int getCountByQuery(Integer goodsId,String userName, String content);


}
