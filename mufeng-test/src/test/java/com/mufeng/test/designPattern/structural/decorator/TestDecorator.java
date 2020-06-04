package com.mufeng.test.designPattern.structural.decorator;

import org.junit.Test;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/3 16:38
 */
public class TestDecorator {
    @Test
    public void test1(){
        Component component=new ConcreteComponent();
        component.operation();
        Decorator decorator=new ConcreteDecorator(component);
        decorator.operation();
    }
}
