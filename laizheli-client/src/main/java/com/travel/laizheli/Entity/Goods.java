package com.travel.laizheli.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
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
    private String coverImageUrl;
    private String detailImageUrl;
    private String beginPlace;
    private String endPlace;
    private String accrosPlace;
    private String serviceEnsure;
    private String transport;
    private Integer days;
    private Date earliestDate;
    private Date lastestDate;
    private BigDecimal adultPrice;
    private BigDecimal childPrice;
    private BigDecimal otherExpense;
    private String characteristic;
    private String costDescription;
    private String attention;
    private Double score;
    private Integer stock;
    private Integer alreadySold;
    /**
     * 商品状态：
     * 1：未发布
     * 2：已发布，未上架
     * 3：已上架
     */
    private String state;
    private Integer visits;
    private Date createTime;

}
