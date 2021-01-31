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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: Goods
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/26 20:39
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String type;
    private String name;
    private String supplierId;
    private String coverImageUrl;
    private String detailImageUrl;
    private String beginPlace;
    private String endPlace;
    private String acrossPlace;
    private String serviceEnsure;
    private String transport;
    private Integer days;
    private Date earliestDate;
    private Date latestDate;
    private BigDecimal adultPrice;
    private BigDecimal childPrice;
    private BigDecimal otherExpense;
    private String characteristic;
    private String costDescription;
    private String attention;
    private Double score;
    private Integer stock;
    private Integer sold;
    private String state;
    private Integer visits;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    public String getEarliestDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (earliestDate != null)
        {
            String earliest = sdf.format(earliestDate);
            return earliest;
        }
        return null;
    }

    public String getLatestDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (latestDate != null)
        {
            String latest = sdf.format(latestDate);
            return latest;
        }
        return null;
    }
}
