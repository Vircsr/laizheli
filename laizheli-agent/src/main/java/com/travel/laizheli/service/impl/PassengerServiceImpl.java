package com.travel.laizheli.service.impl;

import com.travel.laizheli.entity.Passenger;
import com.travel.laizheli.mapper.PassengerMapper;
import com.travel.laizheli.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: PassengerServiceImpl
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/2/1 18:53
 * @Version: 1.0
 **/
@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerMapper passengerMapper;

    /**
     * @Description: 根据订单ID获取旅客信息列表
     * @Param: orderId 
    **/        
    @Override
    public List<Passenger> getByOrderId(Integer orderId) {
        return passengerMapper.getByOrderId(orderId);
    }

}
