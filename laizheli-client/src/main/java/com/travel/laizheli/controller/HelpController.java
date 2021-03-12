package com.travel.laizheli.controller;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.Help;
import com.travel.laizheli.entity.Orders;
import com.travel.laizheli.service.IHelpService;
import com.travel.laizheli.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;

/**
 * @author Nemo
 * @date 2021/1/28
 */
@RestController
@RequestMapping("help")
public class HelpController {

    @Autowired
    private IHelpService helpService;

    @Autowired
    private IOrdersService ordersService;


    /**
     * 通过订单id获取所有助力的用户id
     * @param orderId 订单id
     * @return
     */
    @GetMapping("/users/{orderId}")
    public Result getUsersIdByOrderId(@PathVariable long orderId) {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("order_id", orderId);
        List users = helpService.list(queryWrapper);

        if (users != null) {
            return Result.success(users);
        } else {
            return Result.failed();
        }
    }

    /**
     * 添加助力，助力金额范围默认为0~10元
     * @param orderId
     * @param userId
     * @param range 助力金额范围
     * @return
     */
    @Transactional
    @PostMapping("/help/{orderId}/{userId}")
    public Result addHelp(@PathVariable long orderId, @PathVariable String userId,
                          @RequestParam(defaultValue = "10") int range) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userId);

        Orders ordersById = ordersService.getById(orderId);
        // 判断一下是不是本人，如果是本人，则不可以助力
        if (ordersById.getUserId().equals(userId)) {
            return Result.failed("本人不可以助力哦，快邀请您的好友吧！");
        }
        // 判断助力人数是否已满，如果是，则不可以助力
        if (ordersById.getHelpNum() >= 5) {
            return Result.failed("助力人数已满了哦，请下次再来吧~");
        }

        queryWrapper.eq("order_id", orderId);

        Help one = helpService.getOne(queryWrapper);

        if (one != null) {
            return Result.failed("您已经助力过了，请下次再来哦！");
        }

        Help help = new Help();
        help.setUserId(userId);
        help.setOrderId(orderId);
        help.setCreateTime(DateTime.now());

        // 随机生成助力金额
        Random random = new Random();
        double nextDouble = random.nextDouble();

        // 生成0~10的金额，保留两位小数
        BigDecimal bigDecimal = new BigDecimal(nextDouble * range);

        help.setDiscount(bigDecimal);

        boolean save = helpService.save(help);

        // 订单的总折扣金额也要相应增加
        ordersById.setDiscount(ordersById.getDiscount().add(bigDecimal));
        ordersById.setHelpNum(ordersById.getHelpNum() + 1);
        boolean saveOrders = ordersService.updateById(ordersById);

        if (save && saveOrders) {
            return Result.success(null, "您为好友省下了：￥" + help.getDiscount());
        } else {
            return Result.failed();
        }
    }

    /**
     * 添加助力，助力金额范围为0~10元
     * @param orderId
     * @param userId 为0时则删除该订单下的所有用户
     * @return
     */
    @DeleteMapping("/help/{orderId}/{userId}")
    public Result delHelp(@PathVariable long orderId, @PathVariable String userId) {
        QueryWrapper queryWrapper = new QueryWrapper();

        queryWrapper.eq("order_id", orderId);

        if (!"0".equals(userId)) {
            queryWrapper.eq("user_id", userId);
        }

        boolean remove = helpService.remove(queryWrapper);

        if (remove) {
            return Result.success(null);
        } else {
            return Result.failed();
        }
    }
}
