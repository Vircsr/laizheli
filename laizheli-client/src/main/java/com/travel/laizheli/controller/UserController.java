package com.travel.laizheli.controller;

import cn.hutool.core.date.DateTime;
import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.LoginLog;
import com.travel.laizheli.entity.User;
import com.travel.laizheli.service.ILoginLogService;
import com.travel.laizheli.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nemo
 * @date 2021/1/19
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ILoginLogService loginLogService;

    /**
     * 每当用户登录的时候，添加用户信息
     * @param user
     * @return
     */
    @PostMapping("/user")
    public Result addUser(@RequestBody User user) {
        User userById = userService.getUserById(user.getId());
        log.info("******查询结果：" + userById);
        if (userById != null) {
            return Result.success(null);
        }

        DateTime now = DateTime.now();
        user.setCreateTime(now);
        int result = userService.addUser(user);
        log.info("******插入结果：" + result + user);
        if (result > 0) {
            return Result.success(null);
        } else {
            return Result.failed();
        }
    }

    /**
     * 每当用户登录的时候，添加登录日志
     * @param loginLog
     * @return
     */
    @PostMapping("/loginlog")
    public Result addLoginLog(@RequestBody LoginLog loginLog) {

        DateTime now = DateTime.now();
        loginLog.setCreateTime(now);

        int result = loginLogService.addLoginLog(loginLog);
        if (result > 0) {
            return Result.success(null);
        } else {
            return Result.failed();
        }
    }
}
