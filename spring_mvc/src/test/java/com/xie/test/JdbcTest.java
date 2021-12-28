package com.xie.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.xie.domain.Account;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTest {
    ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
    JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);

    @Test
    // 测试JdbcTemplate开发步骤
    public void test1(){
        // 创建数据源
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db1?serverTimezone=UTC");
        JdbcTemplate template = new JdbcTemplate();
        // 设置数据源对象  知道数据库在哪
        template.setDataSource(dataSource);
        int update = template.update("insert into account(name, balance) values(?, ?)", "bql", 10000);
        System.out.println(update);
    }

    @Test
    // spring产生jdbcTemplate对象
    public void test2(){
        int update = jdbcTemplate.update("insert into account(name, balance) values(?, ?)", "xrz", 100000);
        System.out.println(update);
    }

    @Test
    public void queryAll(){
        List<Account> queryAll = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(queryAll);
    }

    @Test
    public void queryOne(){
        Account queryOne = jdbcTemplate.queryForObject("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), "bql");
        System.out.println(queryOne);
    }

    @Test
    public void queryCount(){
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);
    }
}
