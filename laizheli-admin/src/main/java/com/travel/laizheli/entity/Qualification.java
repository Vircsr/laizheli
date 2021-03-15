package com.travel.laizheli.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yh
 * @Description:
 * @Date: Created in 2021/2/28 16:58
 * @Version：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Qualification implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String supplierId;
    private String name;
    private String representName;
    private String representPhone;
    private String representIdcard;
    private String representImage;
    private String chargeName;
    private String chargePhone;
    private String chargeIdcard;
    private String chargeImage;
    private String licenseImage;
    private Integer state;
    @TableField(exist = false)
    private Integer supplierState;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
