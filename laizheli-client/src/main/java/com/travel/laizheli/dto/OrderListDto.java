package com.travel.laizheli.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Nemo
 * @date 2021/2/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderListDto {
    // Order
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


    // Goods
    // 1. 供应商名称
    /**
     * 非goods表中字段
     * 通过supplierId字段联合查询supplier表中name字段
     */
    @TableField(exist = false)
    private String supplierName;

    // 2. 商品图片
    private String coverImageUrl;

    // 3. 商品名称
    private String name;

    // 4. 商品天数
    private Integer days;

    // 5. 商品交通
    private String transport;


    private BigDecimal adultPrice;
    private BigDecimal childPrice;
    private BigDecimal otherExpense;

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

    public OrderListDto(Orders orders, Goods goods, String supplierName) {
        this.id = orders.getId();
        this.goodsId = goods.getId();
        this.userId = orders.getUserId();
        this.supplierId = orders.getSupplierId();
        this.adultSum = orders.getAdultSum();
        this.childSum = orders.getChildSum();
        this.contactId = orders.getContactId();
        this.state = orders.getState();
        this.totalPrice = orders.getTotalPrice();
        this.discount = orders.getDiscount();
        this.startDate = orders.getStartDate();
        this.helpNum = orders.getHelpNum();
        this.createTime = orders.getCreateTime();

        this.supplierName = supplierName;

        this.coverImageUrl = goods.getCoverImageUrl();
        this.name = goods.getName();
        this.days = goods.getDays();
        this.transport = goods.getTransport();
        this.adultPrice = goods.getAdultPrice();
        this.childPrice = goods.getChildPrice();
        this.otherExpense = goods.getOtherExpense();
    }
}
