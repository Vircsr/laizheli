package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.laizheli.entity.Qualification;
import com.travel.laizheli.mapper.QualificationMapper;
import com.travel.laizheli.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: QualificationServiceImpl
 * @Description: 资质认证服务层实现类
 * @Author: Wangcb
 * @Date: 2021/2/2 17:37
 * @Version: 1.0
 **/
@Service
public class QualificationServiceImpl implements QualificationService {

    @Autowired
    private QualificationMapper qualificationMapper;

    /**
     * @Description: 根据ID查询材料
     * @Param: supplierId 
    **/        
    @Override
    public Qualification getById(String supplierId) {
        QueryWrapper<Qualification> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("supplier_id",supplierId);
        return qualificationMapper.selectOne(queryWrapper);
    }

    /**
     * @Description: 更新审核材料
     * @Param: qualification 
    **/        
    @Override
    public int update(Qualification qualification) {
        return qualificationMapper.updateById(qualification);
    }
}
