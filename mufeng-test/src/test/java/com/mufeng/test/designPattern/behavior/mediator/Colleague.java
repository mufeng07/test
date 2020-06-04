package com.mufeng.test.designPattern.behavior.mediator;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 17:41
 */
public abstract class Colleague {
    protected Mediator mediator;
    public void setMedium(Mediator mediator)
    {
        this.mediator=mediator;
    }
    public abstract void receive();
    public abstract void send();
}
