package com.xie.dao.impl;

import com.xie.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
//        System.out.println("UserDaoImpl创建......");
    }

    public void save() {
        System.out.println("UserDaoImpl执行save......");
    }

    public void init(){
        System.out.println("对象初始化......");
    }

    public void destroy(){
        System.out.println("对象被销毁......");
    }
}
