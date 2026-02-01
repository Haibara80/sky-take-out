package com.sky.handler;

import com.sky.constant.MessageConstant;
import com.sky.exception.BaseException;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 * 使用了 AOP 来拦截所有 Controller 方法的执行
 */
/*
将这个类标记为全局异常处理器,Spring会自动扫描并注册这个类,当项目中任何Controller抛出异常时，都会被这个类拦截
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex){
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }

    @ExceptionHandler
    public Result exceptionHandler(SQLIntegrityConstraintViolationException ex){
        String msg=ex.getMessage();
        if(msg.contains("Duplicate entry")){
            String[] s=msg.split(" ");
            String username=s[2];
            return Result.error("用户名"+username+ MessageConstant.ALREADY_EXISTS);
        }
        else {
            return Result.error("未知错误");
        }
    }
}
