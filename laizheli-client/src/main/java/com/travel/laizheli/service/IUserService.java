package com.travel.laizheli.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.travel.laizheli.Entity.User;

/**
 * @author Nemo
 * @date 2021/1/19
 */
public interface IUserService {

    User getUserById(String id);

    int addUser(User user);
}
