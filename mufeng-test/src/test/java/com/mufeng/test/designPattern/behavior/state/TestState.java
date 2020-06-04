package com.mufeng.test.designPattern.behavior.state;

import org.junit.Test;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 15:25
 */
public class TestState {
    @Test
    public void test1(){
        ThreadContext context=new ThreadContext();
        context.start();
        context.getCPU();
        context.suspend();
        context.resume();
        context.getCPU();
        context.stop();
    }
}
