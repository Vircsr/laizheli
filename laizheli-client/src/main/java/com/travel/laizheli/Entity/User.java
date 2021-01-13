package com.travel.laizheli.Entity;

import lombok.Data;

import java.util.Date;

/**
 * 旅客用户实体类
 * create by chen on 2021/1/13
 */
@Data
public class User {
    private String id;
    private String name;
    private String iconUrl;
    private Date createTime;
}
