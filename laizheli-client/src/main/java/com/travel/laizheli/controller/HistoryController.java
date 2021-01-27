package com.travel.laizheli.controller;

import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.History;
import com.travel.laizheli.service.IHistorySercvice;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 浏览记录
 * create by chen on 2021/1/26
 */
@RestController
@RequestMapping("/history")
public class HistoryController {
    @Resource
    IHistorySercvice historyService;

    /**
     * 添加浏览历史
     * @param history
     * @return
     */
    @PostMapping("/add")
    public Result addHistory(@RequestBody History history){
        return Result.success(historyService.saveHistory(history));
    }

    /**
     * 删除当前用户所有的浏览历史
     * @param userId
     * @return
     */
    @PostMapping("/delete")
    public Result DeleteHistory(@RequestParam String userId){
        String message = historyService.deleteHistory(userId);
        return Result.success(message,message);

    }

    /**
     * 获取当前用户所有的浏览历史，按照时间逆序排列
     * @param userId
     * @return
     */
    @PostMapping("/list")
    public Result getHistoryList(@RequestParam(value = "id") String userId,
                                 @RequestParam(value = "pageNum",defaultValue = "1") Integer current,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer size){
        return Result.success(historyService.getHistoryList(current,size,userId));
    }
}
