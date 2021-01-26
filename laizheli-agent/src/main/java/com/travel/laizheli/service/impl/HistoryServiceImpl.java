package com.travel.laizheli.service.impl;

import com.travel.laizheli.mapper.HistoryMapper;
import com.travel.laizheli.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: HistoryServiceImpl
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/26 22:28
 * @Version: 1.0
 **/
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public int getCount(String supplierId) {
        return historyMapper.getCount(supplierId);
    }
}
