package com.travel.laizheli.service;

import com.travel.laizheli.entity.Supplier;

/**
 * @ClassName: SupplierService
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/24 14:26
 * @Version: 1.0
 **/
public interface SupplierService {

    Supplier getByName(String name,String password);

    int addSupplier(Supplier supplier);

    int updateSupplier(Supplier supplier);
}
