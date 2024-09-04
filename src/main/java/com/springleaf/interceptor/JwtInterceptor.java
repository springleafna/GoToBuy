package com.springleaf.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.springleaf.common.ResultCode;
import com.springleaf.exception.CustomException;
import com.springleaf.mapper.UserMapper;
import com.springleaf.pojo.User;
import io.micrometer.common.util.StringUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Resource
    private UserMapper userMapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token =request.getHeader("token");   //从请求头中获取token
        if(StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
        }

        //执行认证
        if(StringUtils.isEmpty(token)) {
            throw new CustomException(ResultCode.TOKEN_NULL_ERROR);
        }
        //获取token中的userId
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);    //JWT.decode(token) 解码 jwt token
        } catch (JWTDecodeException e) {
            throw new CustomException(ResultCode.TOKEN_INVALID_ERROR);
        }
        //根据token中获取的userId从数据库中找到该用户
        User user = userMapper.selectById(Integer.valueOf(userId));
        if(user == null) {
            throw new CustomException(ResultCode.TOKEN_INVALID_ERROR);
        }

        //通过用户密码加密之后获得一个验证器
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new CustomException(ResultCode.TOKEN_INVALID_ERROR);
        }

        return true;
    }
}