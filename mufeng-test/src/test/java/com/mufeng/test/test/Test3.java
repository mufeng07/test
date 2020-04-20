package com.mufeng.test.test;

import org.junit.Test;

/**
 * @Auther: mufeng
 * @Date: 2019/1/28 18:01
 */
public class Test3 {
    public final int a;
    public Test3(){
        this.a=3;
    }
    @Test
    public void test1(){
        String b;
        new Test4(){
            String b="1";
            @Override
            public String a() {
                b=b;
                return null;
            }
        };
    }

}
