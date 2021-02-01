package com.travel.laizheli.entity;

import cn.hutool.db.DaoTemplate;
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
 * @ClassName: Passenger
 * @Description: 旅客信息表
 * @Author: Wangcb
 * @Date: 2021/2/1 18:45
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private String phone;
    private Integer type;
    private Integer self;
    private String userId;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
