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
 * @ClassName: Scheduling
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/30 14:52
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scheduling implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String general;
    private String sleep;
    private String scenery;
    private String breakfast;
    private String lunch;
    private String dinner;
    private String relax;
    private String attention;
    private Integer goodsId;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}
