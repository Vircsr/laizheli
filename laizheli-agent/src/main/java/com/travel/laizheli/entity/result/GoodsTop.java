package com.travel.laizheli.entity.result;

import com.travel.laizheli.util.SerializeUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: GoodsTop
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/3/4 10:29
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsTop implements Serializable {

    private Integer id;
    private String name;
    private Integer count;
}
