package com.xie.dao.impl;

import com.xie.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void in(String usernameIn, int account) {
        jdbcTemplate.update("update account set balance = balance + ? where name = ?", account, usernameIn);
    }

    public void out(String usernameOut, int account) {
        jdbcTemplate.update("update account set balance = balance - ? where name = ?", account, usernameOut);

    }
}
