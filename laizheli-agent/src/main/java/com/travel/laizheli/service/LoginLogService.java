package com.travel.laizheli.service;

import com.travel.laizheli.entity.LoginLog;

/**
 * @ClassName: LoginLogService
 * @Description: 登录日志服务
 * @Author: Wangcb
 * @Date: 2021/1/25 21:09
 * @Version: 1.0
 **/
public interface LoginLogService {

    int insertLog(LoginLog loginLog);
}
