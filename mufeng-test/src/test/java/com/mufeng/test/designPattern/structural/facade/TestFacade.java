package com.mufeng.test.designPattern.structural.facade;

import org.junit.Test;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/3 16:54
 */
public class TestFacade {
    @Test
    public void test1(){
        Facade facade=new Facade();
        facade.method();
    }
}
