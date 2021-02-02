package com.travel.laizheli.entity;

import com.alibaba.druid.filter.AutoLoad;
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
 * @ClassName: Qualification
 * @Description: 资质认证实体类
 * @Author: Wangcb
 * @Date: 2021/2/2 16:43
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}
