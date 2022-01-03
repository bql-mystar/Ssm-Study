package com.xie.mapper;

import com.xie.domain.User;

import java.util.List;

public interface UserMapper {
    void save(User user);
    List<User> findAll();
}
