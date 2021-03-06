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

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginLog implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String userId;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    private String ip;
    private String os;
    private String browser;
    private String system;
}

