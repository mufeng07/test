package com.mufeng.test.designPattern.behavior.visitor;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 19:03
 */
public interface Visitor {
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}
