package com.mufeng.test.designPattern.behavior.command;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 14:40
 */
public class ConcreteCommand2 implements AbstractCommand {
    private CompositeReceiver receiver;
    ConcreteCommand2()
    {
        receiver=new CompositeReceiver();
    }
    public void execute()
    {
        receiver.action2();
    }
}
