package com.mufeng.test.designPattern.behavior.observer;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 17:26
 */
public class ConcreteObserver1 implements Observer {
    public void response()
    {
        System.out.println("具体观察者1作出反应！");
    }
}
