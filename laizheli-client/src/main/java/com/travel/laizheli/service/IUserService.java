package com.travel.laizheli.service;

import com.travel.laizheli.entity.User;

/**
 * @author Nemo
 * @date 2021/1/19
 */
public interface IUserService {

    /**
     * 通过id得到用户对象
     * @param id
     * @return
     */
    User getUserById(String id);

    /**
     * 增加用户
     * @param user
     * @return
     */
    int addUser(User user);
}
