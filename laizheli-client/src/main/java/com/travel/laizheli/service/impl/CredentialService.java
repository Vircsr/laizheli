package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.travel.laizheli.entity.Credential;
import com.travel.laizheli.entity.Passenger;
import com.travel.laizheli.mapper.CredentialMapper;
import com.travel.laizheli.service.ICredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nemo
 * @date 2021/1/25
 */
@Service
public class CredentialService extends ServiceImpl<CredentialMapper, Credential> implements ICredentialService {

    @Autowired
    private CredentialMapper credentialMapper;

    /**
     * 查询属于此旅客id的所有证件信息
     * @param passengerId
     * @return
     */
    @Override
    public List<Credential> getCredentialsByPassengerId(long passengerId) {

        // 根据旅客id找到其对应的所有证件
        QueryWrapper<Credential> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("passenger_id", passengerId);
        List<Credential> list = credentialMapper.selectList(queryWrapper);

        return list;
    }

    /**
     * 添加证件列表
     *
     * @param credentials
     * @return
     */
    @Override
    public int addCredentials(List<Credential> credentials) {



        return 0;
    }
}
