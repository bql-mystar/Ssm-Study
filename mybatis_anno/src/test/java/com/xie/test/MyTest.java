package com.xie.test;


import com.xie.domain.Account;
import com.xie.mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {

    SqlSession session = null;


    {
        // 获得核心配置文件
        InputStream resource = null;
        try {
            resource = Resources.getResourceAsStream("sqlMapConfig.xml");
            // 获得session工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
            // 获得会话对象
            session = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01(){
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        List<Account> list = mapper.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }

    @Test
    public void test02(){
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        Account account = new Account();
        account.setBalance(99999);
        account.setName("xiexiexie");
        mapper.save(account);
    }

    @Test
    public void test03(){
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        Account account = new Account();
        account.setId(100004);
        account.setBalance(88888);
        mapper.update(account);
    }

    @Test
    public void test04(){
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        mapper.delete(100004);
    }


}
