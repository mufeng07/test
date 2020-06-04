package com.mufeng.test.designPattern.behavior.memento;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 19:08
 */
public class Memento {
    private String state;
    public Memento(String state)
    {
        this.state=state;
    }
    public void setState(String state)
    {
        this.state=state;
    }
    public String getState()
    {
        return state;
    }
}
