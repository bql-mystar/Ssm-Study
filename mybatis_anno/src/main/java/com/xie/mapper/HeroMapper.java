package com.xie.mapper;

import com.xie.domain.Book;
import com.xie.domain.Hero;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HeroMapper {
    // 一对一查询
//    @Select("SELECT *, hero.id hid, book.id bid FROM heroinfo hero, bookinfo book WHERE hero.hbook_id = book.id")
//    @Results({
//            @Result(column="hid", property="id"),
//            @Result(column="hname", property="hname"),
//            @Result(column="hgender", property="hgender"),
//            @Result(column="hcomment", property="hcomment"),
//            @Result(column="bid", property="book.id"),
//            @Result(column="btitle", property="book.btitle"),
//            @Result(column="bpub_date", property="book.bpubDate")
//    })
//    List<Hero> findAll();

    @Select("SELECT * FROM heroinfo;")
    @Results({
            @Result(column="id", property="id"),
            @Result(column="hname", property="hname"),
            @Result(column="hgender", property="hgender"),
            @Result(column="hcomment", property="hcomment"),
            @Result(
                    property = "user",  // 要封装的属性名
                    column = "hbook_id",    // 根据哪个字段去查询bookinfo表的数据
                    javaType = Book.class,  // 要封装的实体类型
                    // select属性 代表查询哪个接口的方法获得数据
                    one = @One(select = "com.xie.mapper.BookMapper.findById")
            )
    })
    List<Hero> findAll();

    @Select("select * from heroinfo where hbook_id = #{id}")
    Hero findById(int id);
}
