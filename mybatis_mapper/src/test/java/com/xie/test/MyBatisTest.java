package com.xie.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.domain.Account;
import com.xie.domain.User;
import com.xie.mapper.AccountMapper;
import com.xie.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyBatisTest {

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
        Account account = new Account();
//        account.setId(2);
//        account.setName("李四");
        account.setBalance(8000);
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        List<Account> accountList = mapper.findByCondition(account);
        System.out.println(accountList);
    }

    @Test
    public void test02(){
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(4);
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        List<Account> accountList = mapper.findByIds(ids);
        System.out.println(accountList);
    }

    @Test
    public void test03(){
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("xrz");
        user.setPassword("xrz");
        user.setBirthday(new Date());
        mapper.save(user);
    }

    @Test
    public void test04(){
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();
        System.out.println(userList);
    }

    @Test
    public void test05(){
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        // 设置分页相关参数  当前页 + 每页显示条数
        PageHelper.startPage(2, 3);
        List<Account> accountList = mapper.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }
        // 获得与分页相关参数
        PageInfo<Account> pageInfo = new PageInfo<Account>(accountList);
        System.out.println("上一页是：" + pageInfo.getPrePage());
        System.out.println("下一页是：" + pageInfo.getNextPage());
        System.out.println("每页条数：" + pageInfo.getPageSize());
        System.out.println("总页数为：" + pageInfo.getPages());
        System.out.println(pageInfo);
    }
}
