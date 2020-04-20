package com.mufeng.test.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: mufeng
 * @Date: 2019/4/15 10:11
 */
public class Test6 {
    @Test
    public void test1(){
        int[][] a={{1,2},{2,3}};
        A a1 = new A();
        System.out.println(a1);
        Class<? extends int[][]> aClass = a.getClass();
        System.out.println(aClass.getName());
        System.out.println(a);
        a.toString();
    }
    public class A{

    }
    @Test
    public void test2(){
        List list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.forEach(l->{
            if(l.equals(3)){
                return;
            }
            System.out.println(l);
        });
    }
}
