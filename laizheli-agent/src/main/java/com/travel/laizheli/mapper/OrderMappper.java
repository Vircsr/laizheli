package com.travel.laizheli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travel.laizheli.entity.Orders;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: OrderMappper
 * @Description: 订单
 * @Author: Wangcb
 * @Date: 2021/1/26 21:55
 * @Version: 1.0
 **/
public interface OrderMappper extends BaseMapper<Orders> {

    @Select("select * from orders join goods on orders.goods_id = goods.id where goods.supplier_id = #{supplierId} and goods.type = #{type}")
    List<Orders> getByIdType(String supplierId,String type);
}
