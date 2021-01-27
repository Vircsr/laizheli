package com.travel.laizheli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.laizheli.entity.Contact;
import com.travel.laizheli.mapper.ContactMapper;
import com.travel.laizheli.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Nemo
 * @date 2021/1/25
 */
@Service
public class ContactService implements IContactService {

    @Autowired
    private ContactMapper contactMapper;

    /**
     * 根据现在登录的用户搜索属于他的所有联系人
     * @param userId
     * @return
     */
    @Override
    public List<Contact> getAllContectsByUserId(String userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userId);
        List<Contact> contacts = contactMapper.selectList(queryWrapper);
        return contacts;
    }

    /**
     * 为当前用户添加联系人，这里不需要userid，前端将userid写在隐藏域中即可
     * @param contact
     * @return
     */
    @Override
    public int addContect(Contact contact) {
        // 添加联系人时可能涉及到默认联系人的变更，所以要进行判断
        if (contact.isIsdefault()) {
            updateDefaultContact(contact);
        }
        int result = contactMapper.insert(contact);
        return result;
    }

    /**
     * 工具方法，仅在本类中使用
     * 修改当前联系人为默认联系人，即 将此用户的其他的默认联系人取消
     * @param contact
     */
    private void updateDefaultContact(Contact contact) {
        QueryWrapper queryWrapper = new QueryWrapper();
        Map map = new HashMap();
        map.put("user_id", contact.getUserId());
        map.put("isdefault", true);
        queryWrapper.allEq(map);
        Contact defaultContact = contactMapper.selectOne(queryWrapper);

        if (defaultContact != null) {
            defaultContact.setIsdefault(false);
            contactMapper.updateById(defaultContact);
        }
    }

    /**
     * 通过id得到联系人，方便之后进行修改
     * @param id
     * @return
     */
    @Override
    public Contact getContactById(long id) {
        return contactMapper.selectById(id);
    }

    /**
     * 修改联系人信息，虽然可能涉及到默认联系人的修改，但是contact里面包含了userid
     * @param contact
     * @return
     */
    @Override
    public int updateContact(Contact contact) {
        // 修改联系人时可能涉及到默认联系人的变更，所以要进行判断
        if (contact.isIsdefault()) {
            updateDefaultContact(contact);
        }
        int result = contactMapper.updateById(contact);
        return result;
    }

    /**
     * 通过id删除联系人，这里id是唯一的，所以不需要知道是哪个用户的联系人
     * @param id
     * @return
     */
    @Override
    public int delContectById(long id) {
        int result = contactMapper.deleteById(id);
        return result;
    }
}
