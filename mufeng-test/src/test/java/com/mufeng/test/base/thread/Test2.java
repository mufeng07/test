package com.mufeng.test.base.thread;

/**
 * author: mufeng
 * Date: 2019/12/13 15:43
 */
public class Test2 {
    public static void main(String[] args) {
        Runnable hello = () -> {
            while (true){
                System.out.println("hello");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                    break;
                }
            }
        };
        Thread t=new Thread(hello);
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }
}
