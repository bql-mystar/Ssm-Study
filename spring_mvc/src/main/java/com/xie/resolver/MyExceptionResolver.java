package com.xie.resolver;

import com.xie.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        if (e instanceof ClassCastException){
            mv.addObject("info", "类型转换异常");
        }else if (e instanceof MyException){
            mv.addObject("info", "自定义类型异常");
        }else {
            mv.addObject("info", "其它类型异常");
        }
        mv.setViewName("my-error");
        return mv;
    }
}
