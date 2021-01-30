package com.travel.laizheli.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * 行程安排实体类
 * create by chen on 2021/1/30
 */
@Data
@Builder
@TableName("scheduling")
public class Scheduling {
    @TableId
    private Integer id;
    private String general;
    private String sleep;
    private String scenery;
    private String breakfast;
    private String lunch;
    private String dinner;
    private String relax;
    private String attention;
}
