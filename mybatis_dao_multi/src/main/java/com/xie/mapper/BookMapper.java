package com.xie.mapper;

import com.xie.domain.Book;

import java.util.List;

public interface BookMapper {
    // 一对多查询
    List<Book> findAll();
}
