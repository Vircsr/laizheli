package com.travel.laizheli.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 联系人
 */
public class Contact {

  private long id;
  private String name;  // 联系人姓名
  private String phone; // 联系人电话
  private boolean isdefault;  // 是否为默认联系人
  private String userId;  // 用户ID
  private Date createTime;  // 创建时间
}
