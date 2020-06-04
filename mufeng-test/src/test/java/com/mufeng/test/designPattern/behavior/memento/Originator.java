package com.mufeng.test.designPattern.behavior.memento;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 19:09
 */
public class Originator {
    private String state;
    public void setState(String state)
    {
        this.state=state;
    }
    public String getState()
    {
        return state;
    }
    public Memento createMemento()
    {
        return new Memento(state);
    }
    public void restoreMemento(Memento m)
    {
        this.setState(m.getState());
    }
}
