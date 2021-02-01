package com.travel.laizheli.controller;

import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.Passenger;
import com.travel.laizheli.service.PassengerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReactiveSubscription;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: PassengerController
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/2/1 18:54
 * @Version: 1.0
 **/
@RestController
@RequestMapping("passenger")
@Slf4j
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    /**
     * @Description: 根据订单ID获取旅客信息
     * @Param: orderId 
    **/        
    @GetMapping("/get")
    public Result getById(@RequestParam("orderId")String orderId){
        if (orderId == null){
            return Result.failed("获取旅客ID失败");
        }else {
            List<Passenger> passengerList = passengerService.getByOrderId(Integer.parseInt(orderId));
            if (passengerList != null){
                return Result.success(passengerList,"成功获取旅客信息");
            }else {
                return Result.failed("获取旅客信息失败");
            }
        }

    }
}
