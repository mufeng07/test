package com.mufeng.test.designPattern.abstractFactory;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/1 19:13
 */
public class ConcreteFactory2 implements AbstractFactory {
    @Override
    public Product1 newProduct1() {
        System.out.println("具体工厂2生产具体产品12。。");
        return new ConcreteProduct12();
    }

    @Override
    public Product2 newProduct2() {
        System.out.println("具体工厂2生产具体产品22。。");
        return new ConcreteProduct22();
    }
}
