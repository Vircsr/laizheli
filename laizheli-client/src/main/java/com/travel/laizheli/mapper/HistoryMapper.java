package com.travel.laizheli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.laizheli.entity.History;
import org.apache.ibatis.annotations.Select;

/**
 * 浏览历史
 * create by chen on 2021/1/26
 */
public interface HistoryMapper extends BaseMapper<History> {
    /**
     * 分页获取浏览历史
     * @param page
     * @param id
     * @return
     */
    @Select("SELECT history.*,goods.`name` AS goods_name FROM history LEFT JOIN goods ON goods.id = history.goods_id WHERE history.user_id = #{id}")
    IPage<History> selectHistoryPage(Page<History> page,String id);
}
