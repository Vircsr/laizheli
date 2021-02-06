package com.travel.laizheli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 行程通知
 * create by chen on 2021/2/6
 */
@Data
public class NoticeInfo {
    private Integer id;
    private String supplierName;
    private String goodsName;
    private String coverImageUrl;
    private String beginPlace;
    private String endPlace;
    private Integer days;
    private String transport;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone="GMT+8")
    private Date startDate;
}
