package com.travel.laizheli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.laizheli.dto.GoodsList;
import com.travel.laizheli.entity.Goods;
import org.apache.ibatis.annotations.Select;

/**
 * 旅游项目mapper类
 * create by chen on 2021/1/21
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    @Select("SELECT goods.id, goods.type, goods.`name`, supplier.`name` AS supplier_name, cover_image_url, begin_place, end_place, accros_place, service_ensure, score,already_sold, days, earliest_date FROM goods LEFT JOIN supplier ON goods.supplier_id = supplier.id WHERE goods.type = #{type} ORDER BY goods.already_sold DESC")
    IPage<GoodsList> selectGoodsPage(Page<GoodsList> goodsList,String type);
}
