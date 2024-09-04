package com.springleaf.config;

import com.springleaf.interceptor.JwtInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(jwtInterceptor) //配置jwt的拦截规则
                .addPathPatterns("/**") //拦截所有路径
                .excludePathPatterns("/user/login","/user/register");   //登录接口和注册接口不拦截
    }
}