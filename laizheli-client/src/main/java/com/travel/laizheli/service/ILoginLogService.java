package com.travel.laizheli.service;

import com.travel.laizheli.entity.LoginLog;

/**
 * @author Nemo
 * @date 2021/1/21
 */
public interface ILoginLogService {

    /**
     * 添加登录日志
     * @param loginLog
     * @return
     */
    int addLoginLog(LoginLog loginLog);
}
