package com.xie.mapper;


import com.xie.domain.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountMapper {
    @Select("select * from account")
    List<Account> findAll();

    @Insert("insert into account values(#{id}, #{name}, #{balance})")
    void save(Account account);

    @Update("update account set balance = #{balance} where id = #{id}")
    void update(Account account);

    @Delete("delete from account where id = #{id}")
    void delete(int id);
}
