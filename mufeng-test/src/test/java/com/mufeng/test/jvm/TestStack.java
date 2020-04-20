package com.mufeng.test.jvm;

import org.junit.Test;

/**
 * -Xss栈空间的最大值
 * @auther: mufeng
 * @Date: 2019/11/29 11:24
 */
public class TestStack {
    private int count=0;
    public void recursion(){
        count++;
        recursion();
    }
    @Test
    public void test1(){
        try{
            //调用递归，等待溢出
            recursion();
        }catch (Throwable e){
            System.out.println("deep:"+count);
            e.printStackTrace();
        }
    }
}
