package com.travel.laizheli.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Help {

  private long id;
  private String userId;  // 注意这里是被助力的用户id
  private long orderId;
  private BigDecimal discount;
  private Date createTime;

  public void setDiscount(BigDecimal discount) {

    BigDecimal bigDecimal = discount.setScale(2, RoundingMode.HALF_UP);
    this.discount = bigDecimal;
  }
}
