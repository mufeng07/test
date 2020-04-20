package com.mufeng.test.base.fundamentalType;

import org.junit.Test;

/**
 * @Auther: mufeng
 * @Date: 2019/1/4 11:25
 */
public class TestInteger {
    /**
     * Integer的数据直接赋值，如果在-128到127之间，会直接从缓冲池里获取数据。
     */
    @Test
    public void test1(){
        Integer i1=123;
        Integer i2=123;
        Integer i3=new Integer(123);
        Integer i4=new Integer(123);
        System.out.println(i1==i2);//true
        System.out.println(i3==i4);//false
        System.out.println(i2==i3);//false
        Integer i5=128;
        Integer i6=128;
        Integer i7=new Integer(128);
        Integer i8=new Integer(128);
        System.out.println(i5==i6);//false
        System.out.println(i6==i7);//false
        System.out.println(i7==i8);//false
    }
    @Test
    public void test2(){
        Integer i1=new Integer(3);
        Integer i2=3;     //自动装箱为Integer类型
        int i3=3;
        System.out.println(i1==i2);//false 两个引用
        System.out.println(i1==i3);//true
        System.out.println(i2==i3);//true
    }
}
