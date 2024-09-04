package com.springleaf.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.springleaf.mapper.UserMapper;
import com.springleaf.pojo.User;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;

@Component
public class JwtUtil {
    private static UserMapper staticUserMapper;

    @Resource
    private UserMapper userMapper;

    @PostConstruct
    public void setUserMapper(){
        staticUserMapper = userMapper;
    }

    /*
    * 生成token
    * */
    public static String createToken(String userId, String sign) {
        return JWT.create().withAudience(userId)    //将userId保存到token中，作为载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60))   //设置token失效时间为1小时
                .sign(Algorithm.HMAC256(sign)); //将password作为token的密钥
    }

    /*
    * 获取当前登陆的用户信息
    * */
    public static User getCurrentUser(){
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            if (token == null || token.equals("")) {
                String userId = JWT.decode(token).getAudience().get(0);
                return staticUserMapper.selectById(Integer.valueOf(userId));
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}