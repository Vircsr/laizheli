package com.travel.laizheli.service;

import com.travel.laizheli.entity.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: SupplierService
 * @Description: TODO
 * @Author: yh
 * @Date: 2021/1/24 14:26
 * @Version: 1.0
 **/

public interface SupplierService {

    int getCount();
    public int updateState(Integer state,String id);







}
