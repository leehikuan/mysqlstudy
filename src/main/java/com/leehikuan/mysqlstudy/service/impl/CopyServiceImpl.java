package com.leehikuan.mysqlstudy.service.impl;

import com.leehikuan.mysqlstudy.dao.ReadDao;
import com.leehikuan.mysqlstudy.dao.WriteDao;
import com.leehikuan.mysqlstudy.entity.User;
import com.leehikuan.mysqlstudy.service.CopyService;
import com.leehikuan.mysqlstudy.util.MyTask;
import com.leehikuan.mysqlstudy.util.ThreadPoolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author leehikuan
 * @create 2020-08-14 22:38
 */
@Service
public class CopyServiceImpl implements CopyService {
    @Autowired
    private ReadDao readDao;
    @Autowired
    private WriteDao writeDao;
    @Autowired
    private ThreadPoolUtils threadPoolUtils;
    @Override
    public boolean copy() {
        System.out.println("凯斯勒===");
        Runnable task=new MyTask(0,2,readDao,writeDao);
        Runnable task1=new MyTask(2,2,readDao,writeDao);
//        List<User> list=readDao.getRowsByStartAndEnd(0,10);
//        System.out.println("结果==="+list);
        ThreadPoolExecutor pool = threadPoolUtils.getPool();
         pool.execute(task);
//        pool.execute(task);
//        pool.execute(task1);
        return true;
    }
}
