package com.travel.laizheli.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: Order
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/26 21:44
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer goodsId;
    private String userId;
    private String supplierId;
    private Integer adultSum;
    private Integer childSum;
    private Integer contactId;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    private Integer state;
    private BigDecimal totalPrice;
    private BigDecimal discount;
    private String startDate;
    private Integer helpNum;
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String goodsName;
    @TableField(exist = false)
    private String contactName;
    @TableField(exist = false)
    private String contactPhone;

}
