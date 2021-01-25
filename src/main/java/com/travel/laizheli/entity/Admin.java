package com.travel.laizheli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
/**
 * @Author: yh
 * @Description:
 * @Date: Created in 2021/1/25 8:49
 * @Version：
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private String id;
    private String name;
    private String password;
}
