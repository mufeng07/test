package com.mufeng.test.designPattern.behavior.mediator;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 17:42
 */
public class ConcreteColleague2 extends Colleague {
    public void receive()
    {
        System.out.println("具体同事类2收到请求。");
    }
    public void send()
    {
        System.out.println("具体同事类2发出请求。");
        mediator.relay(this); //请中介者转发
    }
}
