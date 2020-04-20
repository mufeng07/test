package com.mufeng.test.base.designerMode.adapter;

public class WrapperTest {
    public static void main(String[] args) {

        Wrapper wrapper=new Wrapper(new Source());
        wrapper.method1();
        wrapper.method2();
    }
}
