package com.springleaf.service.impl;

import com.springleaf.mapper.UserMapper;
import com.springleaf.pojo.User;
import com.springleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectByUserName(String username) {
        return userMapper.selectByUserName(username);
    }

    @Override
    public void insertUser(String username, String password) {
        userMapper.insertUser(username, password);
    }
}
