package com.travel.laizheli.controller;

import cn.hutool.core.date.DateTime;
import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.entity.Contact;
import com.travel.laizheli.service.IContactService;
import com.travel.laizheli.service.impl.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nemo
 * @date 2021/1/25
 */
@RestController
@RequestMapping("contact")
@Slf4j
public class ContactController {

    @Autowired
    private IContactService contactService;

    /**
     * 查询属于该用户的所有联系人
     * @param userId
     * @return
     */
    @GetMapping("/all/{userId}")
    public Result<List<Contact>> getAllContects(@PathVariable String userId) {
        List<Contact> allContects = contactService.getAllContectsByUserId(userId);
        log.info(allContects.toString());
        if (!allContects.isEmpty()) {
            return Result.success(allContects);
        } else {
            return Result.failed();
        }
    }

    /**
     * 添加联系人，这里不需要userid，前端将userid写在隐藏域中即可
     * @param contact 联系人
     * @return
     */
    @PostMapping("/contact")
    public Result addContect(@RequestBody Contact contact) {
        // 设置创建日期
        contact.setCreateTime(DateTime.now());
        int result = contactService.addContect(contact);
        if (result > 0) {
            return Result.success(null);
        } else {
            return Result.failed();
        }
    }

    /**
     * 通过id删除联系人
     * @param id
     * @return
     */
    @DeleteMapping("/contact/{id}")
    public Result delContectById(@PathVariable long id) {
        int result = contactService.delContectById(id);
        if (result > 0) {
            return Result.success(null);
        } else {
            return Result.failed();
        }
    }


    /**
     * 通过id找到联系人
     * @param id
     * @return
     */
    @GetMapping("/contact/{id}")
    public Result getContactById(@PathVariable long id) {
        Contact contactById = contactService.getContactById(id);

        if (contactById != null) {
            log.info("通过id找到联系人：" + contactById.toString());
            return Result.success(contactById);
        } else {
            return Result.failed();
        }
    }

    /**
     * 修改联系人，因为参数联系人中已经包含了id信息了，所以无需id
     * @param contact
     * @return
     */
    @PutMapping("/contact")
    public Result updateContact(@RequestBody Contact contact) {
        int result = contactService.updateContact(contact);

        if (result > 0) {
            log.info("修改联系人：" + contact.toString());
            return Result.success(null);
        } else {
            return Result.failed();
        }
    }


//    @PostMapping("/test")
//    public void test(@RequestBody List<Long> ids) {
////        ids.forEach(i -> System.out.print(i));
//        ids.forEach(System.out::print);
//        System.out.println();
//    }

}
