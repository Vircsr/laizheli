package com.travel.laizheli.service;

import com.travel.laizheli.entity.Contact;

import java.util.List;

/**
 * @author Nemo
 * @date 2021/1/25
 */
public interface IContactService {

    /**
     * 根据现在登录的用户搜索属于他的所有联系人
     * @param userId
     * @return
     */
    List<Contact> getAllContectsByUserId(String userId);

    /**
     * 为当前用户添加联系人，这里不需要userid，前端将userid写在隐藏域中即可
     * @param contact
     * @return
     */
    int addContect(Contact contact);

    /**
     * 通过id删除联系人，这里id是唯一的，所以不需要知道是哪个用户的联系人
     * @param id
     * @return
     */
    int delContectById(long id);


    /**
     * 通过id得到联系人，方便之后进行修改
     * @param id
     * @return
     */
    Contact getContactById(long id);

    /**
     * 修改联系人信息，虽然可能涉及到默认联系人的修改，但是contact里面包含了userid
     * @param contact
     * @return
     */
    int updateContact(Contact contact);
}
