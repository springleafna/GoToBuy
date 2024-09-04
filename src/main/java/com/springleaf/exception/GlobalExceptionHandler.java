package com.springleaf.exception;

import com.springleaf.common.Result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice(basePackages="com.springleaf.controller")
public class GlobalExceptionHandler {

    // 统一异常处理@ExceptionHandler,主要用于Exception
    @ExceptionHandler(Exception.class)
    @ResponseBody//返回json串
    public Result error(HttpServletRequest request, Exception e){
        System.out.println("异常信息：" + e);
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody//返回json串
    public Result customError(HttpServletRequest request, CustomException e){
        return Result.error(e.getMsg());
    }
}