package com.xie.service.impl;

import com.xie.dao.UserDao;
import com.xie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Component("userService")
@Service("userService")
public class UserServiceImpl implements UserService {

    // @Autowired    // 按照数据类型从Spring容器中进行匹配
    // @Qualifier("userDao")  // 按照id的值从容器中进行匹配，但是要和@Autowired结合使用
    @Resource(name="userDao") // 相当于@Autowired + @Qualifier
    private UserDao userDao;

    public void save() {
        userDao.save();
    }
}
