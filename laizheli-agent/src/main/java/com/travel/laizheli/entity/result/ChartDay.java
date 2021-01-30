package com.travel.laizheli.entity.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ChartDay
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/27 20:15
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChartDay {

    private String label;
    private List<Integer> data = new ArrayList<>();
}
