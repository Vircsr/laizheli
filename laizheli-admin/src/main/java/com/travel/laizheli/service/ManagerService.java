package com.travel.laizheli.service;

import com.travel.laizheli.entity.LoginLog;
import com.travel.laizheli.entity.Manager;

/**
 * @Author: yh
 * @Description:
 * @Date: Created in 2021/3/1 10:01
 * @Version：
 */
public interface ManagerService {
    Manager getByNamePwd(String name, String password);
    int insertLog(LoginLog loginLog);
    int updateManager(Manager manager);

    Manager getById(String id);
}
