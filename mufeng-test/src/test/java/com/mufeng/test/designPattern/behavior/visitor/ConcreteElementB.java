package com.mufeng.test.designPattern.behavior.visitor;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 19:05
 */
public class ConcreteElementB implements Element {
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
    public String operationB()
    {
        return "具体元素B的操作。";
    }
}
