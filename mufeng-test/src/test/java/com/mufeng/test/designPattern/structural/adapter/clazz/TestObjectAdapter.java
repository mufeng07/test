package com.mufeng.test.designPattern.structural.adapter.clazz;

import org.junit.Test;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/2 19:31
 */
public class TestObjectAdapter {
    @Test
    public void test1(){
        Target target = new ClassAdapter();
        target.request();
    }
}
