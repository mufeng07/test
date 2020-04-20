package com.mufeng.test.base.thread;

import org.junit.Test;

/**
 * author: mufeng
 * Date: 2019/12/13 11:12
 */
public class Test1 {
    @Test
    public void test1(){
        int i=1;
        System.out.println(++i + i--);
        Runnable qw = () -> System.out.println("qw");
        Thread t1 = new Thread(qw);
        Thread thread = new Thread(qw, "qwe");
        //System.out.println(t1.isAlive());
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.getState());
        //System.out.println(t1.isAlive());
        System.out.println(t1.getName());
        System.out.println(thread.getName());
        thread.setName("123");
        System.out.println(thread.getName());

    }
}
