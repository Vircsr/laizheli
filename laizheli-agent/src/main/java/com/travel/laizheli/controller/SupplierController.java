package com.travel.laizheli.controller;

import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.Supplier;
import com.travel.laizheli.service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result login(@RequestBody Supplier supplier)
    {
        Supplier supplierGet = supplierService.getByName(supplier.getName(),supplier.getPassword());
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
