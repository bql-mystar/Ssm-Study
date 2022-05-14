package com.xia.service;

import com.xia.domain.Account;

import java.util.List;

public interface AccountService {
    int addAccount(Account account);
    List<Account> findAccount();
}
