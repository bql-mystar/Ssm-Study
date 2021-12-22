package com.xie.factory;

import com.xie.dao.UserDao;
import com.xie.dao.impl.UserDaoImpl;

public class DynamicFactory {
    // 使用 工厂动态方法实例化 实例对象
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
