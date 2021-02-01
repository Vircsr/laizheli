package com.travel.laizheli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travel.laizheli.entity.Passenger;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: PassengerMapper
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/2/1 18:50
 * @Version: 1.0
 **/
public interface PassengerMapper extends BaseMapper<Passenger> {

    @Select("select * from passenger p join passenger_of_order poo on p.id = poo.passenger_id where order_id = #{orderId}")
    List<Passenger> getByOrderId(Integer orderId);
}
