package com.springleaf.controller;

import com.springleaf.common.Result;
import com.springleaf.pojo.User;
import com.springleaf.service.UserService;
import com.springleaf.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //登录
    @PostMapping("/login")
    public Result login(String username, String password) {
        System.out.println(username + " and " + password);
        //根据用户名查找用户
        User user = userService.selectByUserName(username);
        System.out.println(user);
        if(user == null){
            System.out.println("用户名或密码错误");
            return Result.error("用户名或密码错误");
        }

        if(password.equals(user.getPassword())){
            if(user.getType() == 0){
                //TODO:商家登录
                System.out.println("商家登录");
            }else{
                //TODO:用户登录
                System.out.println("用户登录");
            }
            System.out.println("登录成功!");
            String token = JwtUtil.createToken(user.getUserId().toString(), user.getPassword());
            user.setToken(token);
            return Result.success(user);
        }
        System.out.println("用户名或密码错误");
        return Result.error("用户名或密码错误");
    }

    //注册
    @PostMapping("/register")
    public Result register(String username, String password){
        //查询用户
        User u = userService.selectByUserName(username);
        if(u == null){
            //没有占用 注册
            userService.insertUser(username, password);
            return Result.success();
        }else{
            //占用
            System.out.println("该用户名已被占用!");
            return Result.error("该用户名已被占用");
        }
    }
}