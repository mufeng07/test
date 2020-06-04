package com.mufeng.test.designPattern.behavior.strategy;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 11:22
 */
public class ConcreteStrategyA implements Strategy {
    public void strategyMethod()
    {
        System.out.println("具体策略A的策略方法被访问！");
    }
}
