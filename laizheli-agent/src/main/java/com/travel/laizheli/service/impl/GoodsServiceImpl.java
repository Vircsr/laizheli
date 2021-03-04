package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.entity.result.GoodsTop;
import com.travel.laizheli.mapper.GoodsMapper;
import com.travel.laizheli.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: GoodsServiceImpl
 * @Description: 商品服务类
 * @Author: Wangcb
 * @Date: 2021/1/26 21:05
 * @Version: 1.0
 **/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * @Description: 获取商品总数
     * @Param: supplierId
     * @Param: type 
    **/        
    @Override
    public int getCount(String supplierId, String type) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("supplier_id",supplierId);
        queryWrapper.eq("type",type);
        return goodsMapper.selectCount(queryWrapper);
    }

    /**
     * @Description: 根据商品ID获取商品
     * @Param: goodsId
    **/
    @Override
    public Goods getById(Integer goodsId) {
        return goodsMapper.selectById(goodsId);
    }

    /**
     * @Description: 根据查询条件查询商品列表
     * @Param: current   当前页数
     * @Param: size     每页条数
     * @Param: goodsId  商品ID
     * @Param: supplierId   供应商ID
     * @Param: name   商品名称，模糊查询
     * @Param: state   商品状态
    **/        
    @Override
    public IPage<Goods> getListByQuery(Integer current,Integer size,String goodsId,String supplierId,String name,String state,String type) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("supplier_id",supplierId);
        if (!(goodsId =="" || goodsId == null)){
            queryWrapper.eq("id",Integer.parseInt(goodsId));
        }
        if (!(name =="" || name == null)){
            queryWrapper.like("name",name);
        }
        if (!(state=="" || state == null)){
            queryWrapper.eq("state",state);
        }
        if (!(type =="" || type == null)){
            queryWrapper.eq("type",type);
        }
        Page<Goods> page = new Page<>(current,size);
        return goodsMapper.selectPage(page,queryWrapper);
    }

    /**
     * @Description: 更新商品状态
     * @Param: goods 
    **/        
    @Override
    public int updateState(Goods goods) {
        return goodsMapper.updateById(goods);
    }

    /**
     * @Description: 根据商品ID删除商品
     * @Param: goodsId
    **/
    @Override
    public int delete(Integer goodsId) {
        return goodsMapper.deleteById(goodsId);
    }

    /**
     * @Description: 添加商品
     * @Param: goods
    **/
    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.insert(goods);
    }

    /**
     * @Description: 更新商品信息
     * @Param: goods 
    **/             
    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateById(goods);
    }

    /**
     * @Description: 获取销量前5的商品
    **/
    @Override
    public List<GoodsTop> getTop() {
        return goodsMapper.getTop();
    }


}
