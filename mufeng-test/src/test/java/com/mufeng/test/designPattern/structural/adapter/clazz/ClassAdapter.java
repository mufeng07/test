package com.mufeng.test.designPattern.structural.adapter.clazz;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/2 19:29
 */
public class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        specificRequest();
    }
}
