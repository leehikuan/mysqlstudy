package com.leehikuan.mysqlstudy.dao;

import com.leehikuan.mysqlstudy.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author leehikuan
 * @create 2020-08-14 22:42
 */
@Mapper
public interface WriteDao {

    int insertUserList(List<User> list);
}
