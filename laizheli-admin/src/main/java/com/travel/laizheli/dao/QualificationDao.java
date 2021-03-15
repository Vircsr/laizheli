package com.travel.laizheli.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travel.laizheli.entity.Qualification;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ClassName: QualificationDao
 * @Description:
 * @Author: yh
 * @Date: 2021/2/2 17:36
 * @Version: 1.0
 **/
public interface QualificationDao extends BaseMapper<Qualification> {
    @Update("update qualification set state = #{state} where id = #{id}")
    public int update(String id,Integer state);
    @Select("select q.name,q.represent_name,q.represent_phone,q.represent_idcard,q.charge_image,q.supplier_id,s.state as supplierState " +
            "from qualification q join supplier s on q.supplier_id=s.id" )
    List<Qualification> getSupp();

}
