package com.mufeng.test.designPattern.structural.bridge;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/3 16:12
 */
public class RefinedAbstraction extends Abstraction {
    protected RefinedAbstraction(Implementor imple)
    {
        super(imple);
    }
    public void Operation()
    {
        System.out.println("扩展抽象化(Refined Abstraction)角色被访问" );
        imple.OperationImpl();
    }
}
