package com.xie.mapper;

import com.xie.domain.Book;
import com.xie.domain.Hero;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper {
    // 一对多查询
    @Select("SELECT * FROM bookinfo")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "btitle", property = "btitle"),
            @Result(column = "bpub_date", property = "bpubDate"),
            @Result(
                    property = "heroList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.xie.mapper.HeroMapper.findById")
            )
    })
    List<Book> findAll();

    @Select("SELECT * FROM bookinfo where id = #{id};")
    Hero findById(int id);
}
