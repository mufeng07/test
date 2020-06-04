package com.mufeng.test.designPattern.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 17:24
 */
public abstract class Subject {
    protected List<Observer> observers=new ArrayList<Observer>();
    //增加观察者方法
    public void add(Observer observer)
    {
        observers.add(observer);
    }
    //删除观察者方法
    public void remove(Observer observer)
    {
        observers.remove(observer);
    }
    public abstract void notifyObserver(); //通知观察者方法
}
