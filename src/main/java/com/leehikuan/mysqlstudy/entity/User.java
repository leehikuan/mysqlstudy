package com.leehikuan.mysqlstudy.entity;

import lombok.Data;

/**
 * 实体类
 * @author leehikuan
 * @create 2020-08-14 22:44
 */
@Data
public class User {
    private int id;
    private String  name;
    private int age;
    private String  address;
    private char  sex;
}
