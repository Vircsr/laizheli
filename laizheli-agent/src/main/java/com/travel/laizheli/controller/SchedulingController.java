package com.travel.laizheli.controller;

import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.Scheduling;
import com.travel.laizheli.service.SchedulingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: SchedulingController
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/31 12:12
 * @Version: 1.0
 **/
@RestController
@RequestMapping("scheduling")
@Slf4j
public class SchedulingController {

    @Autowired
    private SchedulingService schedulingService;

    @GetMapping("get")
    public Result getAll(@RequestParam("goodsId")Integer goods_id){
        if (goods_id == null){
            return Result.validateFailed("获取商品ID失败");
        }
        List<Scheduling> schedulingList = schedulingService.getAll(goods_id);
        if (schedulingList == null) {
            return Result.failed("获取行程安排失败");
        }else {
            return Result.success(schedulingList,"成功获取行程安排");
        }
    }

    /**
     * @Description: 添加商品的行程安排
     * @Param: scheduling 
    **/        
    @PostMapping("/add")
    public Result addScheduling(@RequestBody Scheduling scheduling){
        if (scheduling == null){
            return Result.validateFailed("获取行程信息失败");
        }
        int result = schedulingService.addScheduling(scheduling);
        if (result == 1){
            return Result.success(null,"成功添加行程信息");
        } else {
            return Result.failed("添加行程信息失败");
        }
    }

    @PostMapping("/update")
    public Result updateScheduling(@RequestBody Scheduling scheduling){
        if (scheduling == null){
            return Result.validateFailed("获取行程信息失败");
        }
        int result = schedulingService.update(scheduling);
        log.info("行程更新结果为:"+result);
        if (result == 1){
            return Result.success(null,"成功更新行程");
        }else {
            return Result.failed("更新行程失败");
        }
    }
}
