package com.mufeng.test.base.thread.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @auther: mufeng
 * @Date: 2019/11/28 10:47
 */
public class Test1 {
    public static void main(String[] args) {
        Executors.newFixedThreadPool(1);
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
        new Semaphore(1);
        new ThreadLocal();
    }
}
