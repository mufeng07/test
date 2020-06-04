package com.mufeng.test.designPattern.structural.proxy.dynamicProxy;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/2 16:02
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("访问真实主题方法...");
    }
}
