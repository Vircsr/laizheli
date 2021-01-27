package com.travel.laizheli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 证件
 */
public class Credential {

  private long id;
  private int type;
  private long age;
  private String number;
  private long passengerId;
  private Date effectiveDate;
  private Date createTime;

  public String getEffectiveDate() {
    if (this.effectiveDate != null) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      String format = simpleDateFormat.format(this.effectiveDate);
      return format;
    }
    return null;
  }
}
