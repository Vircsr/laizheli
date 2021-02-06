package com.travel.laizheli.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.travel.laizheli.dto.NoticeInfo;
import com.travel.laizheli.entity.Orders;

import java.util.Date;
import java.util.List;

/**
 * @author Nemo
 * @date 2021/1/27
 */
public interface IOrdersService extends IService<Orders> {
    List<NoticeInfo> selectNoticeList(String userId, Date now,Date week);
}
