package com.xie.service;

public interface UserService {
   // 转账方法
    public void change(String usernameIn, String usernameOut, int account);
}
