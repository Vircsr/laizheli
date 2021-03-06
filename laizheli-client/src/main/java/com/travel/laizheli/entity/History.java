package com.travel.laizheli.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 个人浏览历史
 * create by chen on 2021/1/26
 */
@Data
@TableName("history")
public class History {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userId;
    private Integer goodsId;
    @TableField(exist = false)
    private String goodsName;
    @TableField(exist = false)
    private String goodsCoverImageUrl;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;
}
