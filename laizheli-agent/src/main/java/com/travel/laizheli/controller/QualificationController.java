package com.travel.laizheli.controller;

import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.Qualification;
import com.travel.laizheli.service.QualificationService;
import com.travel.laizheli.util.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReactiveSubscription;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName: QualificationController
 * @Description: 资质认证控制层
 * @Author: Wangcb
 * @Date: 2021/2/2 17:38
 * @Version: 1.0
 **/
@RestController
@RequestMapping("qualify")
@Slf4j
public class QualificationController {

    @Autowired
    private QualificationService qualificationService;

    /**
     * @Description: 根据供应商ID获取审核材料
     * @Param: supplierId 
    **/        
    @GetMapping("/get")
    public Result getById(@RequestParam("supplierId")String supplierId){
        if (supplierId == null){
            return Result.validateFailed("获取供应商ID失败");
        }
        Qualification qualification = qualificationService.getById(supplierId);
        if (qualification == null){
            return Result.failed("找不到审核材料");
        }
        return Result.success(qualification,"成功获取审核材料");
    }

    /**
     * @Description: 上传商品图片
     * @Param: multipartFile
     **/
    @PostMapping("/upload")
    public Result upload(@RequestParam("upload") MultipartFile multipartFile) throws IOException {
        if (multipartFile==null){
            return Result.validateFailed("获取文件错误,请重新选择文件");
        }
        String filename = FileUploadUtil.uploadFile(multipartFile);
        return Result.success(filename,"图片上传成功");
    }

    /**
     * @Description: 更新审核材料
     * @Param: qualification 
    **/        
    @PostMapping("/update")
    public Result update(@RequestBody Qualification qualification){
        if (qualification == null){
            return Result.validateFailed("材料获取失败");
        }
        int result = qualificationService.update(qualification);
        if (result !=1 ){
            return Result.failed("更新材料失败");
        }
        return Result.success(null,"更新成功");
    }
}
