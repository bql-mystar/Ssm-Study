package com.xie.dao.impl;

import com.xie.dao.UserDao;
import com.xie.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {

    private List<String> list;
    private Map<String, User> map;
    private Properties properties;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private String name;
    private int age;

    @Override
    public String toString() {
        return "UserDaoImpl{" +
                "list=" + list +
                ", map=" + map +
                ", properties=" + properties +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

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
