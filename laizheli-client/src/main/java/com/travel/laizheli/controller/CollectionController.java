package com.travel.laizheli.controller;

import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.Collection;
import com.travel.laizheli.entity.History;
import com.travel.laizheli.service.ICollectionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 收藏Controller类
 * create by chen on 2021/1/26
 */
@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Resource
    ICollectionService collectionService;

    /**
     * 添加收藏
     * @param collection 收藏实体
     * @return 成功返回succeed
     */
    @PostMapping("/add")
    public Result addCollection(@RequestBody Collection collection){
        if (collectionService.addCollection(collection)!=0) {
            return Result.success("success");
        }else {
            return Result.failed();
        }
    }

    /**
     * 根据id查询当前用户对应的收藏列表
     * @param userId 用户id
     * @return 收藏列表内容
     */
    @PostMapping("/list")
    public Result collectionList(@RequestParam(value = "id") Integer userId,
                                 @RequestParam(value = "pageNum",defaultValue = "1") Integer current,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer size){
        return Result.success(collectionService.collectionList(userId,current,size));
    }

    /**
     * 删除选中的收藏
     * @param idList
     * @return
     */
    @PostMapping("/delete")
    public Result deleteCollection(@RequestBody List<Integer> idList){
        if (collectionService.deleteCollectionList(idList)!=0){
            return Result.success("success");
        }else {
            return Result.failed();
        }
    }
}
