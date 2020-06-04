package com.mufeng.test.designPattern.structural.adapter.object;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/2 19:29
 */
public class Adaptee {
    public void specificRequest()
    {
        System.out.println("适配者中的业务代码被调用！");
    }
}
