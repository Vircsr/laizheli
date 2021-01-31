package com.travel.laizheli.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.laizheli.entity.History;

/**
 * TODO
 * create by chen on 2021/1/26
 */
public interface IHistorySercvice {
    IPage<History> getHistoryList(Integer current,Integer size,String id);
    String saveHistory(History history);;
    String deleteHistory(String id);
}
