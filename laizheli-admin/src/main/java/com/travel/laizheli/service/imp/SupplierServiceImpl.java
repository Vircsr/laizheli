package com.travel.laizheli.service.imp;

import com.travel.laizheli.dao.SupplierDao;
import com.travel.laizheli.entity.Supplier;
import com.travel.laizheli.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: SupplierServiceImpl
 * @Description: 供应商实现类
 * @Author: yh
 * @Date: 2021/1/24 14:29
 * @Version: 1.0
 **/
@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierDao supplierDao;
    @Override
    public int getCount() {
        return supplierDao.selectCount(null);
    }

    @Override
    public int updateState(Integer state,String id) {
        return supplierDao.updateState(state,id);
    }

//    @Override
//    public int updateState(Supplier supplier) {
//        return supplierDao.updateById(supplier);
//    }

//    @Autowired
//    private SupplierDao supplierDao;

//    @Override
// //   public List<Supplier> getAllSupplier(String id) {
//        return  supplierDao.getAllSupplier(id);
//    }

//    @Override
//    public int updateSupplier(Supplier supplier) {
//        return supplierDao.updateById(supplier);
//    }
//
//    @Override
//    public Supplier getById(String id) {
//        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("id",id);
//        return supplierDao.selectOne(queryWrapper);
//    }


}
