package com.travel.laizheli.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 旅游商品实体类
 * create by chen on 2021/1/20
 */
@Data
@TableName("goods")
public class Goods {
    /**
     * 商品唯一id
     */
    @TableId(value = "id")
    private Integer id;
    /**
     * 1 国内游
     * 2 周边游（有问题）
     * 3 出境游
     * 4 特价游
     */
    private String type;
    private String name;
    private String supplierId;
    /**
     * 非goods表中字段
     * 通过supplierId字段联合查询supplier表中name字段
     */
    @TableField(exist = false)
    private String supplierName;

    private String coverImageUrl;
    private String detailImageUrl;
    private String beginPlace;
    private String endPlace;
    private String acrossPlace;
    private String serviceEnsure;
    private String transport;
    private Integer days;
    private BigDecimal adultPrice;
    private BigDecimal childPrice;
    private BigDecimal otherExpense;
    private String characteristic;
    private Integer schedulingId;
    @TableField(exist = false)
    private String general;
    @TableField(exist = false)
    private String sleep;
    @TableField(exist = false)
    private String scenery;
    @TableField(exist = false)
    private String breakfast;
    @TableField(exist = false)
    private String lunch;
    @TableField(exist = false)
    private String dinner;
    @TableField(exist = false)
    private String relax;
    @TableField(exist = false)
    private String schedulingAttention;

    private String costDescription;
    private String attention;
    private Double score;
    private Integer stock;
    private Integer sold;
    /**
     * 商品状态：
     * 1：未发布
     * 2：已发布，未上架
     * 3：已上架
     */
    private String state;
    private Integer visits;

    @JsonFormat(pattern="MM-dd", timezone="GMT+8")
    private Date earliestDate;
    @JsonFormat(pattern="MM-dd", timezone="GMT+8")
    private Date latestDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;

}
