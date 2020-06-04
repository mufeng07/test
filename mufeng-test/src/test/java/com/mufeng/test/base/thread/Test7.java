package com.mufeng.test.base.thread;

import java.util.concurrent.FutureTask;

/**
 * @description: Callable接口有@FunctionalInterface，可以通过lamada创建
 * @author: mufeng
 * @create: 2020/5/13 17:25
 */
public class Test7 {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask=new FutureTask(()->{
            System.out.println(Thread.currentThread().getName()+"执行中");
            return 1;
        });
        Thread t1=new Thread(futureTask);
        t1.start();
        try {
            System.out.println(Thread.currentThread().getName()+"结束:"+futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
