package com.travel.laizheli.service;

import com.travel.laizheli.entity.Scheduling;

import java.util.List;

/**
 * @ClassName: SchedulingService
 * @Description: 商品的行程安排Serive类
 * @Author: Wangcb
 * @Date: 2021/1/31 12:09
 * @Version: 1.0
 **/
public interface SchedulingService {

    List<Scheduling> getAll(Integer goodsId);

    int addScheduling(Scheduling scheduling);

    int update(Scheduling scheduling);
}
