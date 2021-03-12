package com.travel.laizheli.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.laizheli.entity.History;
import com.travel.laizheli.mapper.HistoryMapper;
import com.travel.laizheli.service.IHistorySercvice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 浏览历史实现类
 * create by chen on 2021/1/26
 */
@Service
public class HistoryService implements IHistorySercvice {
    @Resource
    HistoryMapper historyMapper;

    /**
     * 分页获取浏览记录列表
     *
     * @param current
     * @param size
     * @param id
     * @return
     */
    @Override
    public IPage<History> getHistoryList(Integer current, Integer size, String id) {
        Page<History> page = new Page<>(current, size);
        return historyMapper.selectHistoryPage(page, id);
    }

    /**
     * 保存浏览历史
     *
     * @param history
     * @return
     */
    @Override
    public String saveHistory(History history) {
        history.setCreateTime(DateTime.now());
        historyMapper.insert(history);
        return "insert history";
    }

    /**
     * 删除所有浏览历史
     *
     * @param userId
     * @return
     */
    @Override
    public String deleteHistory(String userId) {
        QueryWrapper<History> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        Integer num = historyMapper.delete(wrapper);
        if (num > 0) {
            return "已删除" + num + "条数据";
        } else {
            return null;
        }
    }

    /**
     * 获取历史访问个人总条数
     *
     * @param userId
     * @return
     */
    @Override
    public Integer getHistoryCount(String userId) {
        QueryWrapper<History> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return historyMapper.selectCount(wrapper);
    }
}
