package com.travel.laizheli.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: History
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/26 22:20
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class History {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String userId;
    private Integer goodsId;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
