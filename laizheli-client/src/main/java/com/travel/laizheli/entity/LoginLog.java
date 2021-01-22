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
  private String userId;
  private Date createTime;
  private String ip;
  private String os;
  private String browser;
  private String system;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }


  public String getOs() {
    return os;
  }

  public void setOs(String os) {
    this.os = os;
  }


  public String getBrowser() {
    return browser;
  }

  public void setBrowser(String browser) {
    this.browser = browser;
  }


  public String getSystem() {
    return system;
  }

  public void setSystem(String system) {
    this.system = system;
  }

}
