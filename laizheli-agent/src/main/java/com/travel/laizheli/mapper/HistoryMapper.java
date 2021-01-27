package com.travel.laizheli.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @ClassName: HistoryMapper
 * @Description: 浏览记录
 * @Author: Wangcb
 * @Date: 2021/1/26 22:23
 * @Version: 1.0
 **/
public interface HistoryMapper {

    @Select("select count(*) from orders join goods on orders.goods_id = goods.id where goods.supplier_id = #{supplierId}")
    int getCount(String supplierId);
}
