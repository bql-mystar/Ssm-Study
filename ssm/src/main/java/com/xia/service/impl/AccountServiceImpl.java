package com.xia.service.impl;

import com.xia.dao.AccountDao;
import com.xia.domain.Account;
import com.xia.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public int addAccount(Account account) {
        int nums = accountDao.addAccount(account);
        return nums;
    }

    @Override
    public List<Account> findAccount() {
        System.out.println("进入service");
        return accountDao.selectAccount();
    }
}
