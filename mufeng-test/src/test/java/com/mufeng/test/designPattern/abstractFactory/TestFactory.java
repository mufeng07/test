package com.mufeng.test.designPattern.abstractFactory;

import org.junit.Test;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/1 19:16
 */
public class TestFactory {
    @Test
    public void test1(){
      AbstractFactory af=new ConcreteFactory1();
        Product1 product1 = af.newProduct1();
        product1.show();
    }
}
