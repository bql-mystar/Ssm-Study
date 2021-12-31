package com.xie;

import com.xie.proxy.jdk.Advice;
import com.xie.proxy.jdk.TargetInterface;
import com.xie.proxy.jdk.impl.Target;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    // 基于jdk的动态代理对象
    @Test
    public void test01(){
        // 目标对象
        final Target target = new Target();

        // 增强对象
        final Advice advice = new Advice();

        // 返回值就是动态代理生成的代理对象
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标对象类加载器
                target.getClass().getInterfaces(), // 目标对象相同的接口字节码对象数组
                new InvocationHandler() {
                    // 调用代理对象的任何方法，实质执行的都是invoke方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before();
                        Object invoke = method.invoke(target, args);// 执行目标方法
                        advice.after();
                        return invoke;
                    }
                }
        );

        proxy.save();
    }

    // 基于cglib的动态代理对象
    @Test
    public void test02(){
        // 目标对象
        final Target target = new Target();
        // 增强对象
        final Advice advice = new Advice();

        // 1、创建增强器
        Enhancer enhancer = new Enhancer();
        // 2、设置父类（目标）
        enhancer.setSuperclass(Target.class);
        // 3、设置回调
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                // 执行前置
                advice.before();
                // 执行目标
                Object invoke = method.invoke(target, args);
                // 执行后置
                advice.after();
                return invoke;
            }
        });
        // 4、创建代理对象
        Target proxy = (Target) enhancer.create();
        proxy.save();
    }
}
