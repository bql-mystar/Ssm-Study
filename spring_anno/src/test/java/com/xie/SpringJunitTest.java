package com.xie;

import com.alibaba.druid.pool.DruidDataSource;
import com.xie.config.SpringConfig;
import com.xie.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 使用Spring集成Junit
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SpringJunitTest {

    @Autowired
    private UserService userService;

    @Autowired
    private DruidDataSource dataSource;

    @Test
    public void test01(){
        userService.save();
        System.out.println(dataSource);
    }

}
