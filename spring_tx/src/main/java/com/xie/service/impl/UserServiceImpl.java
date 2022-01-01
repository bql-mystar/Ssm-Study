package com.xie.service.impl;

import com.xie.dao.UserDao;
import com.xie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void change(String usernameIn, String usernameOut, int account) {
        userDao.in(usernameIn, account);
        int i = 1 / 0;
        userDao.out(usernameOut, account);
    }
}
