package com.travel.laizheli.controller;

import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: OrderController
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/26 21:58
 * @Version: 1.0
 **/
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/count")
    public Result getCount(@RequestParam("supplierId")String supplierId){
        if (supplierId.length()<=0){
            return Result.validateFailed("供应商ID获取失败");
        }
        int count = orderService.getCount(supplierId);
        return Result.success(count,"成功获取订单总量");
    }
}
