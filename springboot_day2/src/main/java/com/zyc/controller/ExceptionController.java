package com.zyc.controller;

import com.zyc.utils.MyException;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

//配置全局异常  异常的时候 会挑到这里
@ControllerAdvice   // 也有RestControllerAdvice
public class ExceptionController {

    private static final Logger log =  LoggerFactory.getLogger(ExceptionController.class);

    //返货json
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object exceptonAllJson(Exception e, HttpServletRequest request){
        log.error("msg {},url {}",e.getMessage(),request.getRequestURI());
        return "error";
    }
    //页面跳转
    /*@ExceptionHandler(value = MyException.class)
    public String errorPage( Exception e,HttpServletRequest request){

        return "error/error";
    }*/

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Object myExceptonAllJson(MyException e, HttpServletRequest request){
        log.error("code{}, msg {},url {}",e.getCode(),e.getMsg(),request.getRequestURI());
        return "error";
    }
}
