package com.xie.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect // 标注这是一个切面
public class MyAspect {
    @Before("MyAspect.pointCut()")
    public void before(){
        System.out.println("前置增强......");
    }

    public void after(){
        System.out.println("后置增强......");
    }

    // Proceeding JoinPoint：正在执行的连接点===切点
    // @Around("execution(public void com.xie.anno.Target.save())")
    @Around("pointCut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕增强前......");
        pjp.proceed();  // 切点方法
        System.out.println("环绕增强后......");
    }

    @Pointcut("execution(public void com.xie.anno.Target.save())")
    public void pointCut(){}
}
