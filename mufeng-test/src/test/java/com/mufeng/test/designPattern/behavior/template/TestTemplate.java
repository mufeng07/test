package com.mufeng.test.designPattern.behavior.template;

import org.junit.Test;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 10:25
 */
public class TestTemplate {
    @Test
    public void test1(){
        HookAbstractClass tm=new HookConcreteClass();
        tm.TemplateMethod();
    }
}
