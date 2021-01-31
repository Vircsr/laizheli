package com.travel.laizheli.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.laizheli.entity.Collection;
import com.travel.laizheli.mapper.CollectionMapper;
import com.travel.laizheli.service.ICollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * collection实现
 * create by chen on 2021/1/26
 */
@Service
public class CollectionService implements ICollectionService {
    @Resource
    CollectionMapper collectionMapper;
    @Override
    public Integer addCollection(Collection collection) {
        collection.setCreateTime(DateTime.now());
        return collectionMapper.insert(collection);
    }

    @Override
    public IPage<Collection> collectionList(String userId, Integer current, Integer size) {
        Page<Collection> page  = new Page<Collection>(current,size);
        return collectionMapper.selectCollectionPage(page,userId);
    }

    @Override
    public Integer deleteCollectionList(List<Integer> idList) {
        return collectionMapper.deleteBatchIds(idList);
    }
}
