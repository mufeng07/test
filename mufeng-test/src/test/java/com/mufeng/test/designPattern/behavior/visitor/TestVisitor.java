package com.mufeng.test.designPattern.behavior.visitor;

import org.junit.Test;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 19:06
 */
public class TestVisitor {
    @Test
    public void test1(){
        ObjectStructure os=new ObjectStructure();
        os.add(new ConcreteElementA());
        os.add(new ConcreteElementB());
        Visitor visitor=new ConcreteVisitorA();
        os.accept(visitor);
        System.out.println("------------------------");
        visitor=new ConcreteVisitorB();
        os.accept(visitor);
    }
}
