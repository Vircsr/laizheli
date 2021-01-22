package com.travel.laizheli.service;

import com.travel.laizheli.entity.User;

/**
 * @author Nemo
 * @date 2021/1/19
 */
public interface IUserService {

    User getUserById(String id);

    int addUser(User user);
}
