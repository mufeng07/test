package com.mufeng.test.designPattern.structural.composite;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/3 18:28
 */
public class Leaf implements Component {
    private String name;
    public Leaf(String name)
    {
        this.name=name;
    }
    public void operation()
    {
        System.out.println("树叶"+name+"：被访问！");
    }
}
