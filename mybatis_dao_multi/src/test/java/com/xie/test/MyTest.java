package com.xie.test;

import com.xie.domain.Book;
import com.xie.domain.Hero;
import com.xie.mapper.BookMapper;
import com.xie.mapper.HeroMapper;
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
        HeroMapper mapper = session.getMapper(HeroMapper.class);
        List<Hero> heroes = mapper.findAll();
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    @Test
    public void test02(){
        BookMapper mapper = session.getMapper(BookMapper.class);
        List<Book> bookList = mapper.findAll();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    public void test03(){
        HeroMapper mapper = session.getMapper(HeroMapper.class);
        List<Hero> heroList = mapper.findAll();
        for (Hero hero : heroList) {
            System.out.println(hero);
        }
    }

    @Test
    public void test04(){
        BookMapper mapper = session.getMapper(BookMapper.class);
        List<Book> bookList = mapper.findAll();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
