package com.mufeng.test.designPattern.behavior.observer;

import org.junit.Test;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 17:28
 */
public class TestObserver {
    @Test
    public void test1(){
        Subject subject=new ConcreteSubject();
        Observer obs1=new ConcreteObserver1();
        Observer obs2=new ConcreteObserver2();
        subject.add(obs1);
        subject.add(obs2);
        subject.notifyObserver();
    }
}
