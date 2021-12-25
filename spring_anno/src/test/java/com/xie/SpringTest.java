package com.xie;

import com.alibaba.druid.pool.DruidDataSource;
import com.xie.config.SpringConfig;
import com.xie.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test01(){
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }

    @Test
    public void test02(){
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        DruidDataSource dataSource = app.getBean(DruidDataSource.class);
        System.out.println(dataSource);
    }
}
