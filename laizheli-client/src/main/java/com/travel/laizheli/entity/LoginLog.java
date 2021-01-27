package com.travel.laizheli.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginLog {

  private long id;
  private String userId;  // 用户id
  private Date createTime;  // 登陆时间
  private String ip;  // 登录者ip
  private String os;  // 登录者操作系统
  private String browser; // 登录者浏览器
  private String system;  // 登录者登录的系统，如微信小程序客户端
}
