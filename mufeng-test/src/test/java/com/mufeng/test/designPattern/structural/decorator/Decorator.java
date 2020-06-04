package com.mufeng.test.designPattern.structural.decorator;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/3 16:35
 */
public class Decorator implements Component{
    private Component component;
    public Decorator(Component component)
    {
        this.component=component;
    }
    public void operation()
    {
        component.operation();
    }
}
