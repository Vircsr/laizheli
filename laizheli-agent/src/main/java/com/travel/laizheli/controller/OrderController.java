package com.travel.laizheli.controller;

import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.Orders;
import com.travel.laizheli.entity.result.ChartDay;
import com.travel.laizheli.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

/**
 * @ClassName: OrderController
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/26 21:58
 * @Version: 1.0
 **/
@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * @Description: 根据供应商ID获取订单总量
     * @Param: supplierId 
    **/        
    @GetMapping("/count")
    public Result getCount(@RequestParam("supplierId")String supplierId){
        if (supplierId.length()<=0){
            return Result.validateFailed("供应商ID获取失败");
        }
        int count = orderService.getCount(supplierId);
        return Result.success(count,"成功获取订单总量");
    }

    /**
     * @Description: 获取一周的销量
     * @Param: supplierId 
    **/        
    @GetMapping("/chartDay")
    public Result getChartDay(@RequestParam("supplierId")String supplierId){
        if (supplierId.length()<=0){
            return Result.validateFailed("获取供应商ID失败");
        }
        // 初始化返回结果列表
        List<ChartDay> resultDay = new ArrayList<>();
        for (int i=0;i<4;i++){
            ChartDay chartDay = new ChartDay();
            if (i==0){
                chartDay.setLabel("国内游");
            }else if (i==1){
                chartDay.setLabel("周边游");
            }else if (i==2){
                chartDay.setLabel("出境游");
            }else if (i==3){
                chartDay.setLabel("特价游");
            }
            // 获取国内游产品
            List<Orders> ordersInland = orderService.getByIdType(supplierId, String.valueOf(i+1));
            // 获取当前月份
            int month = LocalDate.now().getMonthValue();
            // 初始化星期销量
            int mon = 0;
            int tues = 0;
            int wed = 0;
            int thur = 0;
            int fri = 0;
            int sat = 0;
            int sun = 0;
            for (int j = 0; j < ordersInland.size(); j++) {
                if (ordersInland.get(j).getCreateTime().getMonth()+1==month){
                    if (ordersInland.get(j).getCreateTime().getDay()==0){
                        mon++;
                    }
                    if (ordersInland.get(j).getCreateTime().getDay()==1){
                        tues++;
                    }
                    if (ordersInland.get(j).getCreateTime().getDay()==2){
                        wed++;
                    }
                    if (ordersInland.get(j).getCreateTime().getDay()==3){
                        thur++;
                    }
                    if (ordersInland.get(j).getCreateTime().getDay()==4){
                        fri++;
                    }
                    if (ordersInland.get(j).getCreateTime().getDay()==5){
                        sat++;
                    }
                    if (ordersInland.get(j).getCreateTime().getDay()==6){
                        sun++;
                    }
                }
            }
            chartDay.getData().add(mon);
            chartDay.getData().add(tues);
            chartDay.getData().add(wed);
            chartDay.getData().add(thur);
            chartDay.getData().add(fri);
            chartDay.getData().add(sat);
            chartDay.getData().add(sun);

            resultDay.add(chartDay);
        }
        return Result.success(resultDay,"成功获取一周各商品销量");
    }

    /**
     * @Description: 获取近5个月的各类商品的销量
     * @Param: supplierId 
    **/        
    @GetMapping("/chartMonth")
    public Result getChartMonth(@RequestParam("supplierId")String supplierId){
        if (supplierId.length()<=0){
            return Result.validateFailed("获取供应商ID失败");
        }
        // 初始化返回结果列表
        List<ChartDay> resultMonth = new ArrayList<>();
        // 获取当前月份
        int month = LocalDate.now().getMonthValue()-1;
        for (int i=0;i<4;i++){
            ChartDay chartMonth = new ChartDay();
            if (i==0){
                chartMonth.setLabel("国内游");
            }else if (i==1){
                chartMonth.setLabel("周边游");
            }else if (i==2){
                chartMonth.setLabel("出境游");
            }else if (i==3){
                chartMonth.setLabel("特价游");
            }
            // 获取国内游产品
            List<Orders> ordersInland = orderService.getByIdType(supplierId, String.valueOf(i+1));

            // 初始化星期销量
            int first = 0;
            int second = 0;
            int third = 0;
            int fourth = 0;
            int fifth = 0;
            for (int j = 0; j < ordersInland.size(); j++) {
                    if (ordersInland.get(j).getCreateTime().getMonth()==(month+12)%12){
                        fifth++;
                    }
                    if (ordersInland.get(j).getCreateTime().getMonth()==(month-1+12)%12){
                        fourth++;
                    }
                    if (ordersInland.get(j).getCreateTime().getMonth()==(month-2+12)%12){
                        third++;
                    }
                    if (ordersInland.get(j).getCreateTime().getMonth()==(month-3+12)%12){
                        second++;
                    }
                    if (ordersInland.get(j).getCreateTime().getMonth()==(month-4+12)%12){
                        first++;
                    }
            }
            chartMonth.getData().add(first);
            chartMonth.getData().add(second);
            chartMonth.getData().add(third);
            chartMonth.getData().add(fourth);
            chartMonth.getData().add(fifth);

            resultMonth.add(chartMonth);
        }
        // 设置显示的日期
        List<String> listLabel = new ArrayList<>();
        listLabel.add((month-4+12)%12+1+"月");
        listLabel.add((month-3+12)%12+1+"月");
        listLabel.add((month-2+12)%12+1+"月");
        listLabel.add((month-1+12)%12+1+"月");
        listLabel.add(month+1+"月");
        // 设置返回数据
        Map map = new HashMap();
        map.put("labels",listLabel);
        map.put("data",resultMonth);
        return Result.success(map,"成功获取各月各商品销量");
    }

    /**
     * @Description: 根据查询条件查询订单列表
     * @Param: supplierId
     * @Param: orderId
     * @Param: goodsName
     * @Param: contactName
     * @Param: state
     * @Param: userName
     * @Param: current
     * @Param: size 
    **/        
    @GetMapping("/get")
    public Result getByQuery(@RequestParam("supplierId")String supplierId,
                             @RequestParam("orderId")String orderId,
                             @RequestParam("goodsName")String goodsName,
                             @RequestParam("contactName")String contactName,
                             @RequestParam("state")String state,
                             @RequestParam("userName")String userName,
                             @RequestParam("current")Integer current,
                             @RequestParam("size")Integer size
                             ){

        Integer order;
        Integer startIndex = (current-1)*size;
        if (orderId==null || orderId==""){
            order =null;
        }else {
            order = Integer.parseInt(orderId);
        }
        // 获取查询结果列表
        List<Orders> ordersList = orderService.getByQuery(supplierId,order, goodsName, contactName, state, userName, startIndex, size);
        // 获取查询结果长度
        int count = orderService.getQueryCount(supplierId,order,goodsName,contactName,state,userName);
        if (ordersList != null) {
            Map<String,Object> map = new HashMap<>();
            map.put("data",ordersList);
            map.put("total",count);
            return Result.success(map,"成功获取订单列表");
        }else {
            return Result.failed("获取订单列表失败");
        }
    }

    /**
     * @Description: 更新订单状态信息
     * @Param: orderId
     * @Param: state 
    **/        
    @GetMapping("/updatestate")
    public Result updateState(@RequestParam("orderId")String  orderId,
                              @RequestParam("state")String state){
        if (orderId == null && state == null){
            return Result.validateFailed("获取订单ID失败");
        }
        Orders order = orderService.getById(Integer.parseInt(orderId));
        if (order == null){
            return Result.failed("获取订单失败");
        }
        order.setState(Integer.parseInt(state));
        int result = orderService.update(order);
        if (result != 1){
            return Result.failed("更新失败");
        }
        return Result.success(null,"更新成功");
    }

    /**
     * @Description: 删除订单
     * @Param: orderId
    **/
    @GetMapping("/delete")
    public Result delete(@RequestParam("orderId")Integer orderId){
        if (orderId == null){
            return Result.validateFailed("获取订单ID失败");
        }
        int result = orderService.deleteByid(orderId);
        if (result != 1){
            return Result.failed("删除失败");
        }
        return Result.success(null,"成功删除");
    }

    /**
     * @Description: 更新订单信息
     * @Param: orders 
    **/        
    @PostMapping("/update")
    public Result updateOrder(@RequestBody Orders orders){
        if (orders == null) {
            return Result.validateFailed("获取订单信息失败");
        }
        int result = orderService.update(orders);
        if (result != 1) {
            return Result.failed("更新失败");
        }
        return Result.success(null,"成功更新");
    }
    
}
