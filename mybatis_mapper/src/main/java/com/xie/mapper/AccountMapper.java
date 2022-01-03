package com.xie.mapper;

import com.xie.domain.Account;

import java.util.List;

public interface AccountMapper {
    List<Account> findByCondition(Account account);
    List<Account> findByIds(List<Integer> ids);
    List<Account> findAll();
}
