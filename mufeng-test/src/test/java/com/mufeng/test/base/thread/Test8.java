package com.mufeng.test.base.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/5/13 17:47
 */
public class Test8 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++){
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+"执行中");
            });
        }
        System.out.println("线程任务开始执行");
        executorService.shutdown();
    }
}
