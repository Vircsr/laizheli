package com.travel.laizheli.service;

import com.travel.laizheli.entity.Qualification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: QualificationService
 * @Description: 资质认证服务层
 * @Author: yh
 * @Date: 2021/2/2 17:36
 * @Version: 1.0
 **/
public interface QualificationService {

    public List<Qualification> getAll();

    public List<Qualification> getSupplier();
    //public int updateState(Qualification qualification);

    //更新
    int update(String id, Integer state);
}
