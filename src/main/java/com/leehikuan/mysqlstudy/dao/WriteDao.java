package com.leehikuan.mysqlstudy.dao;

import com.leehikuan.mysqlstudy.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *更新数据库
 * @author leehikuan
 * @create 2020-08-14 22:42
 */
@Mapper
public interface WriteDao {

    @Insert({
            "<script>",
            "insert into user_bak(id, name, age,sex,address) values ",
            "<foreach collection='list' item='item' index='index' separator=','>",
            "(#{item.id}, #{item.name}, #{item.age}, #{item.sex}, #{item.address})",
            "</foreach>",
            "</script>"
    })
    int insertUsers(List<User> list);
}
