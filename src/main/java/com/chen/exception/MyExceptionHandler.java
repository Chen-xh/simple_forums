package com.chen.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author CHEN
 * @date 2020/10/13  18:28
 * 异常统一处理
 */

public class MyExceptionHandler  implements HandlerExceptionResolver{

    @ExceptionHandler(MyException.class)
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 解析出异常类型
        MyException myException = null;
        // 若该异常类型是系统自定义的异常，直接取出异常信息在错误页面展示即可。
        if(ex instanceof MyException){
            myException = (MyException)ex;
            String url =request.getRequestURI().substring(7);
            //错误信息
            String message = myException.getMessage();
            ModelAndView modelAndView = new ModelAndView();
            //将错误信息传到页面
            modelAndView.addObject("message",message);
            //指向错误页面
            modelAndView.setViewName(url);
            return modelAndView;
        }else{
            // 如果不是系统自定义异常，构造一个系统自定义的异常类型，信息为“未知错误”
            myException = new MyException(MyErrorCode.INTERNAL_SERVER_ERROR);
            //错误信息
            String message = myException.getMessage();
            ModelAndView modelAndView = new ModelAndView();
            //将错误信息传到页面
            modelAndView.addObject("message",message);
            //指向错误页面
            modelAndView.setViewName("error");
            return modelAndView;
        }

    }
}