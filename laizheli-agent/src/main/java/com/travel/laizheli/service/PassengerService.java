package com.travel.laizheli.service;

import com.travel.laizheli.entity.Passenger;

import java.util.List;

/**
 * @ClassName: PassengerService
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/2/1 18:52
 * @Version: 1.0
 **/
public interface PassengerService {

    List<Passenger> getByOrderId(Integer orderId);
}
