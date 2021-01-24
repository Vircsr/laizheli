package com.travel.laizheli.controller;

import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.Supplier;
import com.travel.laizheli.service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: SupplierController
 * @Description: TODO
 * @Author: Wangcb
 * @Date: 2021/1/24 14:56
 * @Version: 1.0
 **/
@RestController
@RequestMapping("supplier")
@Slf4j
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/login")
    public Result login(@RequestParam("name") String name,
                        @RequestParam("password") String password)
    {
        Supplier supplierGet = supplierService.getByName(name,password);
        log.info("查询结果为"+supplierGet);
        if (supplierGet != null)
        {
            return Result.success(supplierGet,"登录成功");
        } else
        {
            return Result.failed(" 用户名和密码不匹配");
        }
    }
}
