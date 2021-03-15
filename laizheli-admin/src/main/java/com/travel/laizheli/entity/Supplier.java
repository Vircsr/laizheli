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
import java.util.Date;

/**
 * @ClassName: Supplier
 * @Description: TODO
 * @Author: yh
 * @Date: 2021/1/24 11:06
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private String id;

    private String name;
    private String password;
    private String question1;
    private String answer1;
    private String question2;
    private String answer2;
    private String iconUrl;
    private Date lastLoginTime;
    private BigDecimal account;
    private Integer state;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
