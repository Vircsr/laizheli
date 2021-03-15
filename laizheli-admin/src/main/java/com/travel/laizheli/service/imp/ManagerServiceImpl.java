package com.travel.laizheli.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.laizheli.dao.ManagerDao;
import com.travel.laizheli.dao.LoginLogDao;
import com.travel.laizheli.entity.LoginLog;
import com.travel.laizheli.entity.Manager;
import com.travel.laizheli.entity.Supplier;
import com.travel.laizheli.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yh
 * @Description:
 * @Date: Created in 2021/3/1 10:02
 * @Version：
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;
    @Autowired
    private LoginLogDao loginLogDao;

    @Override
    public Manager getByNamePwd(String name, String password) {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<Manager>();
        queryWrapper.eq("name",name);
        queryWrapper.eq("password",password);
        return managerDao.selectOne(queryWrapper);
    }

    @Override
    public int insertLog(LoginLog loginLog) {
        return loginLogDao.insert(loginLog);
    }

    @Override
    public int updateManager(Manager manager) {
        return managerDao.updateById(manager);
    }

    @Override
    public Manager getById(String id) {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return managerDao.selectOne(queryWrapper);
    }

}
