package com.mufeng.test.base.thread.executor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther: mufeng
 * @Date: 2019/12/3 17:49
 */
public class Test2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CyclicBarrier cyclicBarrier=new CyclicBarrier(10);
        for(int i=0;i<200;i++){
            executorService.execute(new t1(cyclicBarrier));
      }

    }

}

class t1 extends Thread{
    CyclicBarrier cyclicBarrier;

    public t1(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }
    public void run(){
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
//        for(String s:list){
//            if("2".equals(s)){
//                list.remove(s);
//            }
//        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            if("2".equals(iterator.next())){
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
