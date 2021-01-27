package com.travel.laizheli.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 个人浏览历史
 * create by chen on 2021/1/26
 */
@Data
@TableName("history")
public class History {
    @TableId
    private Integer id;
    private String usrId;
    private Integer goodsId;
    @TableField(exist = false)
    private String goodsName;
    private DateTime createTime;
}
