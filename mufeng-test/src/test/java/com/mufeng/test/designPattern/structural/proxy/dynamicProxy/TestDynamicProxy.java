package com.mufeng.test.designPattern.structural.proxy.dynamicProxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/2 16:16
 */
public class TestDynamicProxy {
    @Test
    public void test1(){
        Subject realSubject=new RealSubject();
        InvocationHandler handler=new DynamicProxy(realSubject);
        Subject subject = (Subject)Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);
        subject.request();
    }
}
