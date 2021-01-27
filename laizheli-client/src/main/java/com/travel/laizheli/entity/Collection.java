package com.travel.laizheli.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 收藏实体类
 * create by chen on 2021/1/26
 */
@Data
@TableName("collection")
public class Collection {
    @TableId
    private Integer id;
    private String userId;
    private Integer goodsId;
    private DateTime createTime;

    @TableField(exist = false)
    private String goodsName;
    @TableField(exist = false)
    private String goodsCoverImageUrl;
    @TableField(exist = false)
    private String goodsServiceEnsure;
}
