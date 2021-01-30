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
    /**
     * 旅游项目列表
     * @param goodsList 分页，包含当前页和页面大小
     * @param type 旅游项目类型
     * @return GoodList列表
     */
    @Select("SELECT goods.id, goods.type, goods.`name`, supplier.`name` AS supplier_name, cover_image_url, begin_place, end_place, across_place, transport, service_ensure, score,sold, days, adult_price, earliest_date FROM goods LEFT JOIN supplier ON goods.supplier_id = supplier.id WHERE goods.type = #{type} ORDER BY goods.sold DESC")
    IPage<GoodsList> selectGoodsPage(Page<GoodsList> goodsList,String type);

    /**
     * 通过id获取旅游项目详情
     * @param id goods标识id
     * @return goods详情内容
     */
    @Select("SELECT t1.*,t2.`name` AS supplier_name FROM goods t1 LEFT JOIN supplier t2 ON t1.supplier_id = t2.id WHERE t1.id = #{id}")
    Goods selectGoodsDetail(Integer id);
}
