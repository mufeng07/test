package com.mufeng.test.base.thread;

/**
 * @Auther: mufeng
 * @Date: 2019/1/15 16:33
 */
public class Runnable1 implements Runnable{
    int counter;
    ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
    @Override
    public void run() {
       counter++;
       if(threadLocal.get()!=null){
           threadLocal.set(threadLocal.get().intValue()+1);
       }else{
           threadLocal.set(counter);
       }
        System.out.println("counter:"+counter);
        System.out.println("get:"+threadLocal.get());
    }
}
