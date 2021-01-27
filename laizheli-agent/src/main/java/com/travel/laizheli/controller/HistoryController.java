package com.travel.laizheli.controller;

import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HistoryController
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/26 22:29
 * @Version: 1.0
 **/
@RestController
@RequestMapping("history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/count")
    public Result getCount(@RequestParam("supplierId")String supplierId){
        if (supplierId.length()<=0){
            return Result.validateFailed("获取供应商ID失败");
        }
        int count = historyService.getCount(supplierId);
        return Result.success(count,"成功获取访问量");
    }
}
