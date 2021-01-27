package com.travel.laizheli.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.travel.laizheli.dto.PassengerDto;
import com.travel.laizheli.service.impl.PassengerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 旅客
 */
public class Passenger {

  // 标明主键自增，方便插入时mbp自动设置主键
  @TableId(type = IdType.AUTO)
  private long id;
  private String name;
  private String phone;
  private boolean sex;
  private boolean self;
  private String userId;
  private Date createTime;

  /**
   * 用来分解dto，将dto分为旅客个人信息，方便存储数据库
   * @param passengerDto
   */
  public Passenger(PassengerDto passengerDto) {
    this.id = passengerDto.getId();
    this.name = passengerDto.getName();
    this.phone = passengerDto.getPhone();
    this.sex = passengerDto.isSex();
    this.self = passengerDto.isSelf();
    this.userId = passengerDto.getUserId();
    this.createTime = passengerDto.getCreateTime();
  }
}
