package com.mufeng.test.designPattern.behavior.chain;

import org.junit.Test;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 15:06
 */
public class TestChain {
    @Test
    public void test1(){
        Handler h1=new ConcreteHandler1();
        Handler h2=new ConcreteHandler2();
        h2.setNext(h1);
        h2.handleRequest("one");
    }
}
