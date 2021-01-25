package com.travel.laizheli.controller;

import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.Admin;
import com.travel.laizheli.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: yh
 * @Description:
 * @Date: Created in 2021/1/25 8:47
 * @Version：
 */

@RestController
@RequestMapping("supplier")
@Slf4j
public class AdminController {
    @Autowired
    private AdminService supplierService;

    @PostMapping("/login")
    public Result login(@RequestParam("name") String name,
                        @RequestParam("password") String password)
    {
        Admin adminGet = adminService.getByName(name,password);
        log.info("查询结果为"+adminGet);
        if (adminGet != null)
        {
            return Result.success(adminGet,"登录成功");
        } else
        {
            return Result.failed(" 用户名和密码不匹配");
        }
    }
}
