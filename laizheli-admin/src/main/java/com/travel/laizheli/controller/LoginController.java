package com.travel.laizheli.controller;


import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.Manager;
import com.travel.laizheli.entity.Supplier;
import com.travel.laizheli.service.ManagerService;
import com.travel.laizheli.service.LoginLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author: yh
 * @Description:
 * @Date: Created in 2021/2/25 9:59
 * @Version：
 */
@RestController
@RequestMapping("admin")
@Slf4j
public class LoginController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private LoginLogService loginLogService;
    // 登录
    @PostMapping("/login")
    public Result login(@RequestParam("name") String name,
                        @RequestParam("password") String password)
    {
        Manager managerGet = managerService.getByNamePwd(name,password);
        log.info("查询结果为"+ managerGet);
        if (managerGet != null)
        {
            return Result.success(managerGet,"登录成功");
        } else
        {
            return Result.failed(" 用户名和密码不匹配");
        }
    }
    /**
     * @Description: 更新上次登录时间
     * @Param: id
     **/
    @PostMapping("/lastLogin")
    public Result updateLoginTime(@RequestParam("id")String id){
        Manager manager = managerService.getById(id);
        manager.setLastLoginTime(new Date());
        int result = managerService.updateManager(manager);
        if (result==1){
            return Result.success(manager,"上次登录时间写入成功");
        }else {
            return Result.failed("上次登录时间写入失败");
        }
    }

//    /**
//     * @Description: 更新上次登录时间
//     * @Param: id
//     **/
//    @PostMapping("/lastLogin")
//    public Result updateLoginTime(@RequestParam("id")String id){
//        Admin admin = adminService.getById(id);
//        admin.setLastLoginTime(new Date());
//        int result = adminService.updateSupplier(supplier);
//        if (result==1){
//            return Result.success(admin,"上次登录时间写入成功");
//        }else {
//            return Result.failed("上次登录时间写入失败");
//        }
//    }
}
