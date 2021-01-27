package com.travel.laizheli.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.travel.laizheli.entity.Credential;

import java.util.List;

/**
 * @author Nemo
 * @date 2021/1/25
 */
public interface ICredentialService extends IService<Credential> {
    /**
     * 查询属于此旅客id的所有证件信息
     * @param passengerId
     * @return
     */
    List<Credential> getCredentialsByPassengerId(long passengerId);

    /**
     * 添加证件列表
     * @param credentials
     * @return
     */
    int addCredentials(List<Credential> credentials);
}
