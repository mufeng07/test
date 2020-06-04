package com.mufeng.test.designPattern.behavior.observer;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 17:25
 */
public class ConcreteSubject extends Subject {
    public void notifyObserver()
    {
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");

        for(Object obs:observers)
        {
            ((Observer)obs).response();
        }

    }
}
