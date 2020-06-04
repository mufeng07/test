package com.mufeng.test.designPattern.structural.bridge;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/3 16:13
 */
public class ConcreteImplementorA implements Implementor {
    public void OperationImpl()
    {
        System.out.println("具体实现化(Concrete Implementor)角色被访问" );
    }
}
