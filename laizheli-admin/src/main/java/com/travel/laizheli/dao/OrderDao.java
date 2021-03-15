package com.travel.laizheli.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travel.laizheli.entity.Orders;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: OrderMappper
 * @Description: 订单
 * @Author: yh
 * @Date: 2021/1/26 21:55
 * @Version: 1.0
 **/
public interface OrderDao extends BaseMapper<Orders> {

//    @Select("select * from orders join goods on orders.goods_id = goods.id where goods.supplier_id = #{supplierId} and goods.type = #{type}")
//    List<Orders> getByIdType(String supplierId, String type);

    List<Orders> getByQuery(@Param("orderId") Integer orderId, @Param("goodsName") String goodsName, @Param("supplierName")String supplierName,@Param("contactName")String contactName, @Param("state")String state, @Param("userName")String userName,@Param("startIndex")Integer startIndex, @Param("size")Integer size);

    int getQueryCount(@Param("orderId")Integer orderId,@Param("goodsName")String goodsName, @Param("contactName")String contactName,@Param("state")String state,@Param("userName")String userName);
    @Select("select sum(total_price) from orders where state=4")
    int getTotalPrice();
}
