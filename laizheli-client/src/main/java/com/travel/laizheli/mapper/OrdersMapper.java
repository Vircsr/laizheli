package com.travel.laizheli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travel.laizheli.dto.NoticeInfo;
import com.travel.laizheli.entity.Orders;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * @author Nemo
 * @date 2021/1/27
 */
public interface OrdersMapper extends BaseMapper<Orders> {
    @Select("SELECT orders.id, orders.start_date,goods.`name` AS goods_name,goods.cover_image_url,goods.begin_place,goods.end_place,goods.transport,goods.days,supplier.`name` AS supplier_name FROM orders LEFT JOIN goods ON orders.goods_id=goods.id LEFT JOIN supplier ON orders.supplier_id=supplier.id WHERE orders.user_id=#{userId} AND orders.start_date BETWEEN #{now} AND #{aWeek}")
    List<NoticeInfo> getNoticeList(String userId, Date now,Date aWeek);
}
