package com.xie.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    public void before(){
        System.out.println("前置增强......");
    }

    public void after(){
        System.out.println("后置增强......");
    }

    // Proceeding JoinPoint：正在执行的连接点===切点
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕增强前......");
        pjp.proceed();  // 切点方法
        System.out.println("环绕增强后......");
    }
}
