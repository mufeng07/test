package com.mufeng.test.designPattern.structural.bridge;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/3 16:11
 */
public abstract class Abstraction {
    protected Implementor imple;
    protected Abstraction(Implementor imple)
    {
        this.imple=imple;
    }
    public abstract void Operation();
}
