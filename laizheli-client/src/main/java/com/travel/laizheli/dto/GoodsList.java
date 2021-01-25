package com.travel.laizheli.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 商品详情显示内容表
 * create by chen on 2021/1/24
 */
@Data
@Builder
public class GoodsList {
    private Integer id;
    private String type;
    private String name;
    private String supplierName;
    private String coverImageUrl;
    private String beginPlace;
    private String endPlace;
    private String accrosPlace;
//  多个字段使用逗号隔开
    private String serviceEnsure;
    private Double score;
    private Integer alreadySold;
    private Integer days;
    private Date earliestDate;

}
