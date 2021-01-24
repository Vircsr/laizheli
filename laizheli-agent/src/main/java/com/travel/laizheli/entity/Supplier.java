package com.travel.laizheli.entity;

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
    private Date createTime;
}
