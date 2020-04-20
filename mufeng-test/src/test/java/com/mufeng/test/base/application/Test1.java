package com.mufeng.test.base.application;

import org.junit.Test;

/**
 * @Auther: mufeng
 * @Date: 2019/4/15 17:49
 */
public class Test1 {
    /**
     *打印9*9乘法表
     */
    @Test
    public void test1(){
        for(int i=1;i<=9;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+"*"+j+"="+i*j+" ");
            }
            System.out.println();
        }
    }
}
