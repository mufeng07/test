package com.mufeng.test.designPattern.behavior.visitor;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 19:04
 */
public class ConcreteVisitorB implements Visitor {
    public void visit(ConcreteElementA element)
    {
        System.out.println("具体访问者B访问-->"+element.operationA());
    }
    public void visit(ConcreteElementB element)
    {
        System.out.println("具体访问者B访问-->"+element.operationB());
    }
}
