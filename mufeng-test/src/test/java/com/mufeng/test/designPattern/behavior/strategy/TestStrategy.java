package com.mufeng.test.designPattern.behavior.strategy;

import org.junit.Test;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 11:44
 */
public class TestStrategy {
    @Test
    public void test1(){
        StrategyFactroy strategyFactroy=new StrategyFactroy();
        Strategy strategyA=new ConcreteStrategyA();
        strategyFactroy.put("A",strategyA);
        strategyFactroy.strategeMethod("A");
        Strategy strategyB=new ConcreteStrategyB();
        strategyFactroy.put("B",strategyB);
        strategyFactroy.strategeMethod("B");
    }
}
