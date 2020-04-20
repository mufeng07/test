package com.mufeng.test.base.date;

import org.junit.Test;

import java.util.Date;

/**
 * @Auther: mufeng
 * @Date: 2019/1/10 19:59
 */
public class TestDate {
    @Test
    public void test1(){
        Date date=new Date();
        long time = date.getTime();
        System.out.println(time);
    }
}
