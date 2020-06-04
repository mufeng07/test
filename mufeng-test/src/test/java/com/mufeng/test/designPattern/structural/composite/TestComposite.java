package com.mufeng.test.designPattern.structural.composite;

import org.junit.Test;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/3 18:30
 */
public class TestComposite {
    @Test
    public void test1(){
        Branch c0=new Branch();
        Branch c1=new Branch();
        Component leaf1=new Leaf("1");
        Component leaf2=new Leaf("2");
        Component leaf3=new Leaf("3");
        c0.add(leaf1);
        c0.add(c1);
        c1.add(leaf2);
        c1.add(leaf3);
        c0.operation();
    }
}
