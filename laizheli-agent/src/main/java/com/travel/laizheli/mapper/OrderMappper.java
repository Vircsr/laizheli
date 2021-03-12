package com.travel.laizheli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travel.laizheli.entity.Orders;
import com.travel.laizheli.entity.result.SumMonth;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
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

    List<Orders> getByQuery(String supplierId,Integer orderId,String goodsName,String contactName,String state,String userName, Integer startIndex,Integer size);

    int getQueryCount(String supplierId,Integer orderId,String goodsName,String contactName,String state,String userName);

    @Select("SELECT sum(total_price - discount) from orders o JOIN goods g on g.id = o.goods_id where o.state = 4 and g.type = #{type}")
    BigDecimal getSumBy(String type);

    @Select("SELECT (total_price - discount) as sum ,create_time as createTime from orders  where state = 4")
    List<SumMonth> getSumMonth();

    @Select("select sum(total_price - discount) from orders where state = 4 and supplier_id = #{supplierId}")
    BigDecimal getAllSale(String supplierId);
}
