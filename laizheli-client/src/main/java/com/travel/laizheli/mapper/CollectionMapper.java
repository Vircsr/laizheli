package com.travel.laizheli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.laizheli.entity.Collection;
import org.apache.ibatis.annotations.Select;

/**
 * 收藏mapper类
 * create by chen on 2021/1/26
 */
public interface CollectionMapper extends BaseMapper<Collection> {
    @Select("SELECT collection.*,goods.`name` AS goods_name,goods.cover_image_url AS goods_cover_image_url,goods.service_ensure AS goods_service_ensure FROM collection LEFT JOIN goods ON goods.id = collection.goods_id WHERE collection.user_id = #{userId}")
    IPage<Collection> selectCollectionPage(Page<Collection> page, String userId);
}
