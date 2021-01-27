package com.travel.laizheli.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Help {

  private long id;
  private String userId;
  private long orderId;
  private BigDecimal discount;
  private Date createTime;

}
