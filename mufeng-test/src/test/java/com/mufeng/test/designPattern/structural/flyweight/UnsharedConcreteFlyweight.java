package com.mufeng.test.designPattern.structural.flyweight;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/3 17:35
 */
public class UnsharedConcreteFlyweight {
    private String info;
    UnsharedConcreteFlyweight(String info)
    {
        this.info=info;
    }
    public String getInfo()
    {
        return info;
    }
    public void setInfo(String info)
    {
        this.info=info;
    }
}
