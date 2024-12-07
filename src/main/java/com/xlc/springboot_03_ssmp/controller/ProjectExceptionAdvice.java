package com.xlc.springboot_03_ssmp.controller;

import com.xlc.springboot_03_ssmp.controller.until.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Classname ProjectExceptionAdvice
 * @Description TODO
 * @Date 2024/12/6 19:13
 * @Created by cxx
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler
    public R doException(Exception e) {
        e.printStackTrace();
        return new R(false, "服务器故障请稍后再试！");
    }
}
