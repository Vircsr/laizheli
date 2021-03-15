package com.travel.laizheli.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travel.laizheli.entity.Supplier;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ClassName: SupplierMapper
 * @Description: TODO
 * @Author: yh
 * @Date: 2021/1/24 14:23
 * @Version: 1.0
 **/
public interface SupplierDao extends BaseMapper<Supplier> {
    @Update("update supplier set state = #{state} where id = #{id}")
    int updateState(Integer state,String id);
}
