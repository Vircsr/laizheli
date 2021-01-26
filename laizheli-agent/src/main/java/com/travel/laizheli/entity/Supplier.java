package com.travel.laizheli.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: Supplier
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/24 11:06
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
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
