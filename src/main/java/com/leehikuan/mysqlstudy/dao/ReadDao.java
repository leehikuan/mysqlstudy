package com.leehikuan.mysqlstudy.dao;

import com.leehikuan.mysqlstudy.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 * 读数据Dao类1
 * @author leehikuan
 * @create 2020-08-14 22:42
 */
@Mapper
public interface ReadDao {

    @Select("select * from user limit #{start},#{size}")
    List<User> getRowsByStartAndEnd(int start,int size);

}
