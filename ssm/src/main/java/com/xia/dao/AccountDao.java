package com.xia.dao;

import com.xia.domain.Account;

import java.util.List;

public interface AccountDao {
    int addAccount(Account account);
    List<Account> selectAccount();
}
