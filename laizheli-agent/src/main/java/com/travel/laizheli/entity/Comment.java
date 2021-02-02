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
 * @ClassName: Comment
 * @Description: 评价实体类
 * @Author: Wangcb
 * @Date: 2021/2/2 11:18
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer goodsId;
    private Integer orderId;
    private Integer userId;
    private Double score;
    private String content;
    private String imageUrl;
    private Integer schedule;
    private Integer guide;
    private Integer sleep;
    private Integer food;
    private Integer scenery;
    private Integer transportation;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(exist = false)
    private String goodsName;
    @TableField(exist = false)
    private String userName;
}
