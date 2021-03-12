package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.laizheli.entity.Supplier;
import com.travel.laizheli.mapper.SupplierMapper;
import com.travel.laizheli.service.SupplierService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: SupplierServiceImpl
 * @Description: 供应商实现类
 * @Author: Wangcb
 * @Date: 2021/1/24 14:29
 * @Version: 1.0
 **/
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public Supplier getByNamePwd(String name,String password) {
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","name","icon_url","last_login_time","account","state");
        queryWrapper.eq("name",name);
        queryWrapper.eq("password",password);
        return supplierMapper.selectOne(queryWrapper);
    }

    @Override
    public Supplier getByName(String name) {
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        return supplierMapper.selectOne(queryWrapper);
    }

    @Override
    public int addSupplier(Supplier supplier) {
        return supplierMapper.insert(supplier);
    }

    @Override
    public int updateSupplier(Supplier supplier) {
        return supplierMapper.updateById(supplier);
    }

    @Override
    public Supplier getById(String id) {
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return supplierMapper.selectOne(queryWrapper);
    }

    @Override
    public int updateAccount(Supplier supplier) {
        return supplierMapper.updateById(supplier);
    }
}
