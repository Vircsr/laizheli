package com.travel.laizheli.controller;

import cn.hutool.core.date.DateTime;
import com.travel.laizheli.Entity.LoginLog;
import com.travel.laizheli.Entity.User;
import com.travel.laizheli.common.api.CommonResult;
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

    @PostMapping("/user")
    public CommonResult addUser(@RequestBody User user) {
        User userById = userService.getUserById(user.getId());
        log.info("******查询结果：" + userById);
        if (userById != null) {
            return CommonResult.success(null);
        }

        DateTime now = DateTime.now();
        user.setCreateTime(now);
        int result = userService.addUser(user);
        log.info("******插入结果：" + result + user);
        if (result > 0) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @PostMapping("/loginlog")
    public CommonResult addLoginLog(@RequestBody LoginLog loginLog) {

        DateTime now = DateTime.now();
        loginLog.setCreateTime(now);

        int result = loginLogService.addLoginLog(loginLog);
        if (result > 0) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }
}
