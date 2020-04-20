package com.mufeng.test.jvm;

import java.util.Vector;

/**
 * -Xmx
 * @auther: mufeng
 * @Date: 2019/11/29 14:09
 */
public class TestXX {
    public static void main(String[] args) {
        Vector v=new Vector();
        for(int i=0;i<10;i++){
            byte[] b=new byte[1024*1024];
            v.add(b);
            System.out.println(i+"M is allocated");
        }
        System.out.println("Max memory:"+Runtime.getRuntime().maxMemory()/1024/1024+"M");
    }
}
