package com.travel.laizheli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: PassengerOfOrder
 * @Description: 订单和旅客对应
 * @Author: Wangcb
 * @Date: 2021/2/1 18:41
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerOfOrder {

    private Integer id;
    private Integer order_id;
    private Integer passenger_id;
}
