package com.travel.laizheli.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

  private long id;
  private long goodsId;
  private String userId;
  private String supplierId;
  private long adultSum;
  private long childSum;
  private long contactId;
  private String passengerId;
  private Date createTime;
  private long state;
  private double totalPrice;
  private double discount;
  private Date startDate;

}
