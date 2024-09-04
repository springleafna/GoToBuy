package com.springleaf.service;

import com.springleaf.pojo.User;

public interface UserService {
    //根据用户名查找用户
    User selectByUserName(String username);

    //添加用户
    void insertUser(String username, String password);
}
