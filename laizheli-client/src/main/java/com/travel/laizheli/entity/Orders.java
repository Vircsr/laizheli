package com.travel.laizheli.entity;


import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
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
  private Date createTime;
  /*
  订单状态：1待付款，2待接单，3待出行，4已出行，5退款中，6已退款，7已取消
   */
  private int state;
  private BigDecimal totalPrice;
  private BigDecimal discount;
  private Date startDate;
  private int helpNum;


  public String getCreateTime() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    String format = simpleDateFormat.format(this.createTime);
    return format;
  }

  public String getStartDate() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    String format = simpleDateFormat.format(this.startDate);
    return format;
  }

  public void setTotalPrice(BigDecimal totalPrice) {
    BigDecimal bigDecimal = totalPrice.setScale(2, RoundingMode.HALF_UP);
    this.totalPrice = bigDecimal;
  }

  public void setDiscount(BigDecimal discount) {

    BigDecimal bigDecimal = discount.setScale(2, RoundingMode.HALF_UP);
    this.discount = bigDecimal;
  }
}
