package com.xie.mapper;

import com.xie.domain.Hero;

import java.util.List;

public interface HeroMapper {
    // 一对一查询
    List<Hero> findAll();
}
