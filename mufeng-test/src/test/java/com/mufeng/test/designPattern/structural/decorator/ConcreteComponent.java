package com.mufeng.test.designPattern.structural.decorator;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/3 16:34
 */
public class ConcreteComponent implements Component {
    public ConcreteComponent()
    {
        System.out.println("创建具体构件角色");
    }
    public void operation()
    {
        System.out.println("调用具体构件角色的方法operation()");
    }
}
