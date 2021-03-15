package com.travel.laizheli.service.imp;

import com.travel.laizheli.dao.LoginLogDao;
import com.travel.laizheli.entity.LoginLog;
import com.travel.laizheli.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: LoginLogServiceImpl
 * @Description: 登录日志服务实现
 * @Author: yh
 * @Date: 2021/1/25 21:10
 * @Version: 1.0
 **/
@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogDao loginLogDao;

    @Override
    public int insertLog(LoginLog loginLog) {
        return loginLogDao.insert(loginLog);
    }
}
