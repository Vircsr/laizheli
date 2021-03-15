package com.travel.laizheli.controller;//package com.travel.laizheli.controller;

import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.Goods;
import com.travel.laizheli.entity.Orders;
import com.travel.laizheli.entity.Qualification;
import com.travel.laizheli.service.QualificationService;
import com.travel.laizheli.util.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReactiveSubscription;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


/**
 * @Author: yh
 * @Description:
 * @Date: Created in 2021/2/28 17:18
 * @Version：
 */
@RestController
@RequestMapping("qualify")
@Slf4j
public class QualificationController {

    @Autowired
    private QualificationService qualificationService;

    /**
     * @Description: 获取审核材料
     * @Param: supplierId
     **/
    @GetMapping("/get")
    public Result getById(){
        List<Qualification> qualification = qualificationService.getAll();
        if (qualification == null){
            return Result.failed("找不到审核材料");
        }
        return Result.success(qualification,"成功获取审核材料");
    }

    @GetMapping("/supplier")
    public Result getSupplier(){
        List<Qualification> qualification = qualificationService.getSupplier();
        //System.out.println(qualification.toString());
        if (qualification == null){
            return Result.failed("找不到供应商");
        }
        return Result.success(qualification,"成功获取供应商");
    }

    @PostMapping("/update")
    public Result updateQua(@RequestParam(value = "id")String id,
                            @RequestParam(value = "state")Integer state){

        int result = qualificationService.update(id,state);
        if (result != 1) {
            return Result.failed("更新失败");
        }
        return Result.success(null,"成功更新");
    }
//    @GetMapping("/state")
//    public Result updateState(@RequestParam("state") Boolean state){
//        int newState = qualificationService.updateState(state);
//        return Result.success(newState,"更新状态成功");
//    }
//@GetMapping("/state")
//public Result updateState(@RequestParam("id")Integer id,
//                          @RequestParam("state")Boolean state){
//    if (id==null){
//        return Result.failed("获取审核ID或者状态值失败");
//    }
//    Qualification qualification =  qualificationService.getSupplier();
//    qualification.setState(state);
//    int result = qualificationService.updateState(qualification);
//    if (result==1){
//        return Result.success(null,"成功更新供应商状态");
//    }else {
//        return Result.failed("更新供应商状态失败");
//    }
////    Goods goods = goodsService.getById(goodsId);
////    goods.setState(state);
////    int result = goodsService.updateState(goods);
////    if (result==1){
////        return Result.success(null,"成功更新商品状态");
////    }else {
////        return Result.failed("更新商品状态失败");
////    }
//}

}
