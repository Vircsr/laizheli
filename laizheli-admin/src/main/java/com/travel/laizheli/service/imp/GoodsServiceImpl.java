package com.travel.laizheli.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.laizheli.dao.GoodsDao;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yh
 * @Description:
 * @Date: Created in 2021/3/2 10:14
 * @Version：
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

//    @Override
//    public IPage<Goods> getPage(Integer current, Integer size) {
//        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
//        Page<Goods> page = new Page<>(current,size);
//        return goodsDao.selectPage(page,queryWrapper);
//    }

//    @Override
//    public List<Goods> getAll() {
//
//        return goodsDao.selectList();
//    }
    /**
     * @Description: 根据查询条件查询商品列表
     * @Param: current   当前页数
     * @Param: size     每页条数
     * @Param: goodsId  商品ID
     * @Param: supplierId   供应商ID
     * @Param: name   商品名称，模糊查询
     * @Param: state   商品状态
     **/
//    @Override
//    public IPage<Goods> getListByQuery(Integer current,Integer size,String goodsId,String name,String state,String type) {
//        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
//        //queryWrapper.eq("supplier_id",supplierId);
//        if (!(goodsId =="" || goodsId == null)){
//            queryWrapper.eq("id",Integer.parseInt(goodsId));
//        }
//        if (!(name =="" || name == null)){
//            queryWrapper.like("name",name);
//        }
//        if (!(state=="" || state == null)){
//            queryWrapper.eq("state",state);
//        }
//        if (!(type =="" || type == null)){
//            queryWrapper.eq("type",type);
//        }
//        Page<Goods> page = new Page<>(current,size);
//        return goodsDao.selectPage(page,queryWrapper);
//    }

    @Override
    public IPage<Goods> getListByQuery(Integer current, Integer size,String name,String state,String goodsId) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        if (!(goodsId =="" || goodsId == null)){
            queryWrapper.eq("id",Integer.parseInt(goodsId));
        }
        if (!(state=="" || state == null)){
            queryWrapper.eq("state",state);
        }
        if (!(name =="" || name == null)){
            queryWrapper.like("name",name);
        }

        Page<Goods> page = new Page<>(current,size);
        return goodsDao.selectPage(page,queryWrapper);
    }

    /**
     * @Description: 获取商品总数
     * @Param: supplierId
     * @Param: type
     **/
    @Override
    public int getCount() {
        return goodsDao.selectCount(null);
    }
    /**
     * @Description: 根据商品ID删除商品
     * @Param: goodsId
     **/
    @Override
    public int delete(Integer goodsId) {
        return goodsDao.deleteById(goodsId);
    }
}
