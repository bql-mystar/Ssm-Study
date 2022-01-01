package com.xie.dao;

public interface UserDao {
    public void in(String usernameIn, int account);
    public void out(String usernameOut, int account);
}
