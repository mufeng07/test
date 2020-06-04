package com.mufeng.test.designPattern.structural.adapter.object;

import org.junit.Test;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/2 19:31
 */
public class TestObjectAdapter {
    @Test
    public void test1(){
        Adaptee adaptee=new Adaptee();
        Target target = new ObjectAdapter(adaptee);
        target.request();
    }
}
