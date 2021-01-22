package com.travel.laizheli.service.impl;

import com.travel.laizheli.entity.LoginLog;
import com.travel.laizheli.mapper.LoginLogMapper;
import com.travel.laizheli.service.ILoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nemo
 * @date 2021/1/21
 */
@Service
public class LoginLogService implements ILoginLogService {

    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public int addLoginLog(LoginLog loginLog) {
        return loginLogMapper.insert(loginLog);
    }
}
