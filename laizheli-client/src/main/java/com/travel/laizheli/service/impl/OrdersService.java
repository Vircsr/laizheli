package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.travel.laizheli.dto.NoticeInfo;
import com.travel.laizheli.entity.Orders;
import com.travel.laizheli.mapper.OrdersMapper;
import com.travel.laizheli.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Nemo
 * @date 2021/1/27
 */
@Service
public class OrdersService extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    @Resource
    private OrdersMapper ordersMapper;

    /**
     * 获取通知列表
     * @param userId
     * @return
     */
    @Override
    public List<NoticeInfo> selectNoticeList(String userId, Date now, Date week) {
        return ordersMapper.getNoticeList(userId,now,week);
    }
}
