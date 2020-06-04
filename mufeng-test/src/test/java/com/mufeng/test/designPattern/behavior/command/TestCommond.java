package com.mufeng.test.designPattern.behavior.command;

import org.junit.Test;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 14:41
 */
public class TestCommond {
    @Test
    public void test1(){
        AbstractCommand c1=new ConcreteCommand1();
        AbstractCommand c2=new ConcreteCommand2();
        CompositeInvoker c3=new CompositeInvoker();
        c3.add(c1);
        c3.add(c2);
        c3.execute();
    }
}
