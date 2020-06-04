package com.mufeng.test.designPattern.structural.adapter.object;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/2 19:29
 */
public class ObjectAdapter implements Target {
    private Adaptee adaptee;
    public ObjectAdapter(Adaptee adaptee){
        this.adaptee=adaptee;
    }
    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
