package com.travel.laizheli.service;

import com.travel.laizheli.entity.Qualification;

/**
 * @ClassName: QualificationService
 * @Description: 资质认证服务层
 * @Author: Wangcb
 * @Date: 2021/2/2 17:36
 * @Version: 1.0
 **/
public interface QualificationService {

    Qualification getById(String supplierId);

    int update(Qualification qualification);
}
