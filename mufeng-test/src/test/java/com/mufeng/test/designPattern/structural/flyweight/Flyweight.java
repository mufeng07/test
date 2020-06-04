package com.mufeng.test.designPattern.structural.flyweight;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/3 17:36
 */
public interface Flyweight {
    void operation(UnsharedConcreteFlyweight state);
}
