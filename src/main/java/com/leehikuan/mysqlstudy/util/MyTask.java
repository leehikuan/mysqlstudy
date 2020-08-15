package com.leehikuan.mysqlstudy.util;

import com.leehikuan.mysqlstudy.dao.ReadDao;
import com.leehikuan.mysqlstudy.dao.WriteDao;
import com.leehikuan.mysqlstudy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author leehikuan
 * @create 2020-08-14 22:39
 */
public class MyTask implements Runnable{
    private int start;
    private int size;
    ReadDao readDao;
    WriteDao writeDao;

    public MyTask(int start, int size,ReadDao readDao,WriteDao writeDao) {
        this.start = start;
        this.size = size;
        this.readDao=readDao;
        this.writeDao=writeDao;
    }

    @Override
    public void run() {
        System.out.println("进入 mytask的run方法");
        //从原表读取start开始 end结束的数据行
        List<User> users = readDao.getRowsByStartAndEnd(start, size);
        System.out.println("mytask===="+users);
        //把这些数据插入到目标表
//        writeDao.insertUserList(users);
    }
}
