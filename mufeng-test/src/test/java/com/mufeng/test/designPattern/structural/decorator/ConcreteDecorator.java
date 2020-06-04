package com.mufeng.test.designPattern.structural.decorator;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/3 16:36
 */
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component)
    {
        super(component);
    }
    public void operation()
    {
        super.operation();
        addedFunction();
    }
    public void addedFunction()
    {
        System.out.println("为具体构件角色增加额外的功能addedFunction()");
    }
}
