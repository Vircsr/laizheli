package com.travel.laizheli.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: LoginLog
 * @Description: 登录日志实体
 * @Author: Wangcb
 * @Date: 2021/1/25 21:02
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginLog {

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
