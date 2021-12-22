package com.xie.test;

import com.xie.dao.UserDao;
import com.xie.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
//    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
    ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test01(){
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.save();
//        app.close();
    }
    // 测试scope属性，在不配置scope属性的时候，默认是单例
    @Test
    public void test02(){
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
        System.out.println(userDao2);
    }

    @Test
    public void test03(){
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }

}
