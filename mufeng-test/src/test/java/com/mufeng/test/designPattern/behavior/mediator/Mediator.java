package com.mufeng.test.designPattern.behavior.mediator;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 17:39
 */
public abstract class Mediator {
    public abstract void register(Colleague colleague);
    public abstract void relay(Colleague cl); //转发
}
