package com.travel.laizheli.controller;

import cn.hutool.core.date.DateTime;
import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.LoginLog;
import com.travel.laizheli.entity.Supplier;
import com.travel.laizheli.service.LoginLogService;
import com.travel.laizheli.service.SupplierService;
import com.travel.laizheli.util.FileUploadUtil;
import com.travel.laizheli.util.IpUtil;
import com.travel.laizheli.util.OsAndBrowserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

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

    @Autowired
    private LoginLogService loginLogService;

    // 登录
    @PostMapping("/login")
    public Result login(@RequestParam("name") String name,
                        @RequestParam("password") String password)
    {
        Supplier supplierGet = supplierService.getByNamePwd(name,password);
        log.info("查询结果为"+supplierGet);
        if (supplierGet != null)
        {
            return Result.success(supplierGet,"登录成功");
        } else
        {
            return Result.failed(" 用户名和密码不匹配");
        }
    }
    // 注册
    @PostMapping("/register")
    public Result register(@RequestBody Supplier supplier)
    {
        supplier.setAccount(new BigDecimal(0));
        supplier.setState(1);
        int result = supplierService.addSupplier(supplier);
        log.info("插入结果为"+result);
        if (result==1)
        {
            return Result.success(null,"注册成功");
        } else
        {
            return Result.failed(" 注册失败");
        }
    }

    // 修改密码
    @PostMapping("/updatepwd")
    public Result updatepwd(@RequestParam("name") String name,
                            @RequestParam("newPwd") String newpassword,
                            @RequestParam("answer1") String answer1,
                            @RequestParam("answer2") String answer2)
    {
        Supplier supplierGet = supplierService.getByName(name);
        log.info("根据名字查询结果为："+supplierGet);
        Supplier updateSupplier = new Supplier();
        updateSupplier.setId(supplierGet.getId());
        updateSupplier.setPassword(newpassword);
        if (supplierGet.getAnswer1().equals(answer1) && supplierGet.getAnswer2().equals(answer2)) {
            int result = supplierService.updateSupplier(updateSupplier);
            log.info("更新密码结果为："+result);
            if (result==1) {
                return Result.success(null,"修改成功");
            }else {
                return Result.failed("修改失败");
            }
        }else
            {
                return Result.failed("密保问题回答错误");
            }
    }

    // 插入登录日志
    @PostMapping("/insert")
    public Result insertLoginLog(@RequestBody LoginLog loginLog,
                                 HttpServletRequest request){
        String ip = IpUtil.getIpAddr(request);
        String os = OsAndBrowserUtil.getOs(request);
        String browser = OsAndBrowserUtil.getBrowser(request);
        loginLog.setIp(ip);
        loginLog.setBrowser(browser);
        loginLog.setOs(os);
        loginLog.setSystem("供应商管理系统");
        int result = loginLogService.insertLog(loginLog);
        if (result==1){
            log.info("日志添加成功");
            return Result.success(null,"日志添加成功");
        }else {
            log.error("日志添加错误");
            return Result.failed("服务器错误，登录日志添加失败");
        }
    }

    /**
     * @Description: 更新上次登录时间
     * @Param: id 
    **/        
    @PostMapping("/lastLogin")
    public Result updateLoginTime(@RequestParam("id")String id){
        Supplier supplier = supplierService.getById(id);
        supplier.setLastLoginTime(new Date());
        int result = supplierService.updateSupplier(supplier);
        if (result==1){
            return Result.success(supplier,"上次登录时间写入成功");
        }else {
            return Result.failed("上次登录时间写入失败");
        }
    }

    /**
     * @Description: 更换头像
     * @Param: id
     * @Param: data 
    **/        
    @PostMapping("/updateIcon")
    public Result updateIcon(@RequestParam("id") String id,
                             @RequestParam("updateIcon") String data) throws IOException {

        if (data.length()==0){
            log.error("上传文件为空");
            return Result.failed("文件选择为空");
        }
        Supplier supplier = supplierService.getById(id);
        // 生成文件名
        String filename = UUID.randomUUID().toString()+".png";
        // 将base64转成图片存起来
        boolean generateImage = FileUploadUtil.generateImage(data, FileUploadUtil.getPath() + filename);
        if (!generateImage){
            log.error("base64转成图片失败");
            return Result.failed("文件转存失败");
        }
        supplier.setIconUrl(filename);
        int result = supplierService.updateSupplier(supplier);
        if (result==1){
            return Result.success(supplier,"头像修改成功");
        }else {
            return Result.failed("头像修改失败");
        }
    }

    /**
     * @Description: 提现
     * @Param: supplierId 
    **/        
    @GetMapping("/cash")
    public Result updateAccount(@RequestParam("supplierID")String supplierId){
        if (supplierId == null){
            return Result.validateFailed("获取供应商ID失败");
        }
        Supplier supplier = supplierService.getById(supplierId);
        if (supplier == null){
            return Result.failed("用户不存在");
        }
        supplier.setAccount(new BigDecimal(0));
        int result = supplierService.updateSupplier(supplier);
        if (result != 1){
            return Result.failed("提现失败");
        }
        return Result.success(null,"提现成功");
    }
}
