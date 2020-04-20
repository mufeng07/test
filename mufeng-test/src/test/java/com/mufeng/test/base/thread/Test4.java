package com.mufeng.test.base.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author: mufeng
 * Date: 2019/12/16 14:22
 */
public class Test4 {
    final static int READS=3;
    public static void main(String[] args) {
        CountDownLatch start=new CountDownLatch(1);
        CountDownLatch done=new CountDownLatch(READS);
        Runnable runnable = () -> {
            try {
                report("11");
                start.await();
                report("22");
                Thread.sleep(10*1000);
                done.countDown();
                System.out.println("66");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(READS);
        for(int i=0;i<READS;i++){
            executorService.execute(runnable);
        }
        System.out.println("33");
        try {
            Thread.sleep(1000);
            start.countDown();
            System.out.println("44");
            done.await();
            System.out.println("55");
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    static void report(String s){
        System.out.println(System.currentTimeMillis()+":"+Thread.currentThread()+":"+s);
    }
}
