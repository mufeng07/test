package com.mufeng.test.base.thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * author: mufeng
 * Date: 2019/12/17 16:55
 */
public class ReentrantReadWriteLockTest {
    public static int count = 5;

    public static void main(String[] args) {
        //创建一个非公平的读写锁
        ReadWriteLock lock = new ReentrantReadWriteLock(false);

        Thread threadA = new Thread("threadA"){
            @Override
            public void run() {
                //获取读锁
                lock.readLock().lock();
                System.out.println("成功获取读锁，count的值是："+count);
                if(count<10){
                    lock.readLock().unlock();
                    //在获取写锁前，必须先释放读锁
                    lock.writeLock().lock();
                    System.out.println("成功获取写锁");
                    count += count*3;

                    //获取读锁，此时没有释放写锁，即为写锁降级为读锁
                    lock.readLock().lock();
                    //成功获取读锁，写锁降级成功，释放写锁
                    lock.writeLock().unlock();
                    System.out.println("写锁成功降级成读锁，count的值是："+count);
                }
            }
        };
        threadA.start();
    }
}
