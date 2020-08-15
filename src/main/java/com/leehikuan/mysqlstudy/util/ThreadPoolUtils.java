package com.leehikuan.mysqlstudy.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author leehikuan
 * @create 2020-08-14 19:10
 */
@Configuration
public class ThreadPoolUtils {
    @Value("${thread.coreNum:3}")
    private int coreThreadNum;
    @Value("${thread.aliveTime:3000}")
    private int aliveTime;

    @Value("${thread.maxNum:5}")
    private int maxThreadNum;

    private ThreadPoolExecutor pool;
    private final int  queueSize=3;
    public  ThreadPoolExecutor getPool() {
        if (pool == null) {
           pool= createThreadPool ();
        }
        return pool;
    }

    private ThreadPoolExecutor createThreadPool(){
        pool=new ThreadPoolExecutor(coreThreadNum,maxThreadNum,aliveTime, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(queueSize),
                new MyThreadFactory("我的线程"),
                new ThreadPoolExecutor.CallerRunsPolicy());
        return pool;
    }

    class MyThreadFactory implements ThreadFactory {

        private String  poolName;

        private AtomicInteger count = new AtomicInteger(0);
        public MyThreadFactory(String poolName){
            this.poolName = poolName;
        }
        @Override
        public Thread newThread(Runnable r) {
            Thread t=new Thread();
            t.setName(poolName+count.addAndGet(1));
            r.run();
            return t;
        }
    }


}
