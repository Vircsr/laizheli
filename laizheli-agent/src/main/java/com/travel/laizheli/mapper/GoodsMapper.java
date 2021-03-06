package com.travel.laizheli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.entity.result.GoodsTop;

import java.util.List;

/**
 * @ClassName: GoodsMapper
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/26 21:00
 * @Version: 1.0
 **/
public interface GoodsMapper extends BaseMapper<Goods> {

    List<GoodsTop> getTop();
}
