package com.travel.laizheli.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.laizheli.entity.Collection;

import java.util.List;

/**
 * 收藏接口
 * create by chen on 2021/1/26
 */
public interface ICollectionService {
    Integer addCollection(Collection collection);
    IPage<Collection> collectionList(String userId, Integer current, Integer size);
    Integer deleteCollectionList(List<Integer> idList);
}
