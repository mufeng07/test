package com.mufeng.test.designPattern.behavior.memento;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 19:09
 */
public class Caretaker {
    private Memento memento;
    public void setMemento(Memento m)
    {
        memento=m;
    }
    public Memento getMemento()
    {
        return memento;
    }
}
