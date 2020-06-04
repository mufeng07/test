package com.mufeng.test.base.thread;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/5/13 17:12
 */
public class Test5 {
    public static void main(String[] args) {
       MyThread t1=new MyThread();
       t1.start();
        System.out.println(Thread.currentThread().getName()+"执行完成。");
    }
}
class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"执行中。。。");
    }
}
