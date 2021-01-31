package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.entity.Scheduling;
import com.travel.laizheli.mapper.SchedulingMapper;
import com.travel.laizheli.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: SchedulingServiceImpl
 * @Description: 商品的行程安排
 * @Author: Wangcb
 * @Date: 2021/1/31 12:11
 * @Version: 1.0
 **/
@Service
public class SchedulingServiceImpl implements SchedulingService {

    @Autowired
    private SchedulingMapper schedulingMapper;

    /**
     * @Description: 根据商品ID获取所属行程安排
     * @Param: goodsId 
    **/        
    @Override
    public List<Scheduling> getAll(Integer goodsId) {
        QueryWrapper<Scheduling> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_id",goodsId);
        return schedulingMapper.selectList(queryWrapper);
    }

    /**
     * @Description: 添加商品行程
     * @Param: scheduling
    **/
    @Override
    public int addScheduling(Scheduling scheduling) {
        return schedulingMapper.insert(scheduling);
    }

    /**
     * @Description: 更新商品行程信息
     * @Param: scheduling
    **/
    @Override
    public int update(Scheduling scheduling) {
        return schedulingMapper.updateById(scheduling);
    }
}
