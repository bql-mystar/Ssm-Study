package com.xie.test;

import com.xie.dao.JobMapper;
import com.xie.domain.Account;
import com.xie.domain.Job;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
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
            session = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01() throws IOException {
        // 获得核心配置文件
        InputStream resource = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        // 获得会话对象
        SqlSession session = sqlSessionFactory.openSession();
        // 执行操作   参数：namespace + id
        List<Account> accountList = session.selectList("accountMapper.findAll");
        for (Account account : accountList) {
            System.out.println(account);
        }
        // 释放资源
        session.close();
    }

    @Test
    public void test02(){
        Account account = new Account();
        account.setName("zhenge");
        account.setBalance(100000);
        session.insert("accountMapper.addOne", account);
        session.commit();
    }

    @Test
    public void test03(){
        Account account = new Account();
        account.setId(100003);
        account.setBalance(111111);
        session.insert("accountMapper.update", account);
        session.commit();
    }

    @Test
    public void test04(){
        session.delete("accountMapper.delete", 100);
        session.commit();
    }

    @Test
    public void test05(){
        JobMapper mapper = session.getMapper(JobMapper.class);
        List<Job> jobList = mapper.findAll();
        System.out.println(jobList);
    }

    @Test
    public void test06(){
        JobMapper mapper = session.getMapper(JobMapper.class);
        Job job = mapper.findById(1);
        System.out.println(job);
    }
}
