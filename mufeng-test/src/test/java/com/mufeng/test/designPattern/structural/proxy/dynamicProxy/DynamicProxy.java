package com.mufeng.test.designPattern.structural.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/2 16:11
 */
public class DynamicProxy implements InvocationHandler {
    private Object subject;
    public DynamicProxy(Object subject){
        this.subject=subject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(subject,args);
        return null;
    }
}
