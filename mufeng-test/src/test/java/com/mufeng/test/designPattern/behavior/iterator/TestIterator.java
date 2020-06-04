package com.mufeng.test.designPattern.behavior.iterator;

import org.junit.Test;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 18:02
 */
public class TestIterator {
    @Test
    public void test1(){
        Aggregate ag=new ConcreteAggregate();
        ag.add("中山大学");
        ag.add("华南理工");
        ag.add("韶关学院");
        System.out.print("聚合的内容有：");
        Iterator it=ag.getIterator();
        while(it.hasNext())
        {
            Object ob=it.next();
            System.out.print(ob.toString()+"\t");
        }
        Object ob=it.first();
        System.out.println("\nFirst："+ob.toString());
    }
}
