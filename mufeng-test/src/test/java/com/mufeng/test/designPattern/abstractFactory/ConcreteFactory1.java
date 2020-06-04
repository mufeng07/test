package com.mufeng.test.designPattern.abstractFactory;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/1 19:13
 */
public class ConcreteFactory1 implements AbstractFactory {
    @Override
    public Product1 newProduct1() {
        System.out.println("具体工厂1生产具体产品11。。");
        return new ConcreteProduct11();
    }

    @Override
    public Product2 newProduct2() {
        System.out.println("具体工厂1生产具体产品21。。");
        return new ConcreteProduct21();
    }
}
