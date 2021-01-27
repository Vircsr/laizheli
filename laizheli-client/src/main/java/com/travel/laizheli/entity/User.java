package com.travel.laizheli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 旅客用户实体类
 * create by chen on 2021/1/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;  // 用户ID，后期用用户的openID代替
    private String name;    // 用户名，小程序端已动态获取，所以不需要了
    private String iconUrl; // 用户头像地址，同上
    private Date createTime;  // 创建时间
}
