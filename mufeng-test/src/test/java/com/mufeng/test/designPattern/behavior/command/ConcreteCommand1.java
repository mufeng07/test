package com.mufeng.test.designPattern.behavior.command;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 14:39
 */
public class ConcreteCommand1 implements AbstractCommand{
    private CompositeReceiver receiver;
    ConcreteCommand1()
    {
        receiver=new CompositeReceiver();
    }
    public void execute()
    {
        receiver.action1();
    }
}
