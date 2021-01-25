package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.laizheli.entity.Admin;
import com.travel.laizheli.mapper.AdminMapper;
import com.travel.laizheli.service.AdminService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @Author: yh
 * @Description:
 * @Date: Created in 2021/1/25 8:56
 * @Version：
 */
public class AdminServiceImpl {
    @Autowired
    private AdminMapper adminMapper;

    public Admin getByName(String name,String password) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        queryWrapper.eq("password",password);
        return adminMapper.selectOne(queryWrapper);
    }
}
