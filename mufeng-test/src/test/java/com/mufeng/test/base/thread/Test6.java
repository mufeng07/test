package com.mufeng.test.base.thread;

/**
 * @description: Runnable接口有@FunctionalInterface，可以通过lamada创建
 * @author: mufeng
 * @create: 2020/5/13 17:20
 */
public class Test6 {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"执行中");
        });
        t1.start();
        System.out.println(Thread.currentThread().getName()+"执行完成。");
    }
}
