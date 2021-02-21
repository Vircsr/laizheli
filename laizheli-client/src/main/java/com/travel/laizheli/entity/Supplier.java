package com.travel.laizheli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

  private String id;
  private String name;    // 供应商名称
  private String password;
  private String question1;
  private String answer1;
  private String question2;
  private String answer2;
  private String iconUrl;
  private java.sql.Timestamp lastLoginTime;
  private double account;
  private long state;
  private java.sql.Timestamp createTime;

}
