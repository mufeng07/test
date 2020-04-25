package com.mufeng.test.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: mufeng
 * @Date: 2019/1/17 09:34
 */
public class Test1 {
    @Test
    public void test1(){
        boolean testb = testb();
        System.out.println(testb);
    }
    private boolean testb(){
        try {
            System.out.println("start");
            return true;

        } finally {
            System.out.println("fstart");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                int b=1/0;
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(123);
        }
    }
    @Test
    public void test3(){
        System.out.println(Math.pow(2,30));
        System.out.println(1<<30);
    }
    @Test
    public void test4(){
        List list=new ArrayList();
        System.out.println("list:"+list);
        list.add(1);
        System.out.println("list:"+list);
    }
    @Test
    public void test5(){
        StringBuilder sb=new StringBuilder();
        sb.append("D,E,");
        String s = sb.substring(0, sb.length() - 1);
        System.out.println(s);
        System.out.println(sb);
    }
    @Test
    public void test6(){
        System.out.println(f(0));
        System.out.println(f(1));
        System.out.println(f(2));

    }
    public static  int f(int x){
        if(x==0){
            return 0; //基准情形
        }else {
            return 2*f(x-1)+x*x;
        }
    }
}
