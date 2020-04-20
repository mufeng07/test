package com.mufeng.test.base.designerMode.singleton;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: mufeng
 * @Date: 2019/3/7 14:11
 */
public class TestCASSingleton {
    public static AtomicInteger count=new AtomicInteger();
    @Test
    public void test1() throws InterruptedException {
        final CountDownLatch begin = new CountDownLatch(1);
        final CountDownLatch last = new CountDownLatch(1000);
        for(int i=0;i<1000;i++){
            System.out.println("你好"+i);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("李四");
                        begin.await();
                        System.out.println(Thread.currentThread().getName()+":begin...");
                        CASSingleton sba = CASSingleton.getInstance();
                        System.out.println(Thread.currentThread().getName()+":OK");
                        last.countDown();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();
        }
        begin.countDown();
        last.await();
        System.out.println("new objects: "+count.get());
    }
}
