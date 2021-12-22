package com.xie.factory;

import com.xie.dao.UserDao;
import com.xie.dao.impl.UserDaoImpl;

public class StaticFactory {
    // 使用 工厂静态方法实例化 实例对象
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
