package com.travel.laizheli.entity.result;

import com.alibaba.druid.filter.AutoLoad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: SumMonth
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/3/11 22:02
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SumMonth implements Serializable {

    private BigDecimal sum;
    private Date createTime;
}
