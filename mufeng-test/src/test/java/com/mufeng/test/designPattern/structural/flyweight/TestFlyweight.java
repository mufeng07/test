package com.mufeng.test.designPattern.structural.flyweight;

import org.junit.Test;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/3 17:39
 */
public class TestFlyweight {
    @Test
    public void test1(){
        FlyweightFactory flyweightFactory=new FlyweightFactory();
        Flyweight a = flyweightFactory.getFlyweight("a");
        flyweightFactory.getFlyweight("a");
        flyweightFactory.getFlyweight("c");

    }
}
