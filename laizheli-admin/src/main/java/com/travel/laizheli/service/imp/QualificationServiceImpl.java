package com.travel.laizheli.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.travel.laizheli.dao.QualificationDao;
import com.travel.laizheli.entity.Qualification;
import com.travel.laizheli.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//import com.travel.laizheli.dao.QualificationDao;

/**
 * @ClassName: QualificationServiceImpl
 * @Description: 资质认证服务层实现类
 * @Author: yh
 * @Date: 2021/2/2 17:37
 * @Version: 1.0
 **/
@Service
public class QualificationServiceImpl implements QualificationService {

    @Autowired
    private QualificationDao qualificationDao;

    /**
     * @Description: 根据ID查询材料
     * @Param: supplierId 
    **/

    @Override
    public List<Qualification> getAll() {
//        QueryWrapper<Qualification> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("supplier_id",supplierId);
        return qualificationDao.selectList(null);
    }

    @Override
    public List<Qualification> getSupplier() {
        return qualificationDao.getSupp();
    }



    @Override
    public int update(String id, Integer state) {
        return qualificationDao.update(id,state);
    }
//    @Override
//    public int updateState(Qualification qualification) {
//        //只更新一个属性，把名字为rhb的用户年龄更新为18，其他属性不变
//        return  qualificationDao.updateById(qualification);
//
//    }
//    @Override
//    public int updateState(int state) {
//        return qualificationDao.selectById(state);
//    }


//    /**
//     * @Description: 更新审核材料
//     * @Param: qualification
//    **/
//    @Override
//    public int update(Qualification qualification) {
//        return qualificationDao.updateById(qualification);
//    }
}
