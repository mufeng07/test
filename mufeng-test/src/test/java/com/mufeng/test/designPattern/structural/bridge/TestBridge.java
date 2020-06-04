package com.mufeng.test.designPattern.structural.bridge;

import org.junit.Test;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/3 16:14
 */
public class TestBridge {
    @Test
    public void test1(){
        Implementor implementor=new ConcreteImplementorA();
        Abstraction abstraction=new RefinedAbstraction(implementor);
        abstraction.Operation();
    }
}
