package com.mufeng.test.designPattern.behavior.mediator;

import org.junit.Test;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 17:43
 */
public class TestMediator {
    @Test
    public void test1(){
        Mediator md=new ConcreteMediator();
        Colleague c1,c2;
        c1=new ConcreteColleague1();
        c2=new ConcreteColleague2();
        md.register(c1);
        md.register(c2);
        c1.send();
        System.out.println("-------------");
        c2.send();
    }
}
