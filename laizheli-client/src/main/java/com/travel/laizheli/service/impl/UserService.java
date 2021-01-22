package com.travel.laizheli.service.impl;

import com.travel.laizheli.Entity.User;
import com.travel.laizheli.mapper.UserMapper;
import com.travel.laizheli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nemo
 * @date 2021/1/20
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }
}
