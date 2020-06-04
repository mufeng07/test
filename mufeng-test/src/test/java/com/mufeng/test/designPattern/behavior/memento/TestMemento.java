package com.mufeng.test.designPattern.behavior.memento;

import org.junit.Test;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 19:11
 */
public class TestMemento {
    @Test
    public void test1(){
        Originator or=new Originator();
        Caretaker cr=new Caretaker();
        or.setState("S0");
        System.out.println("初始状态:"+or.getState());
        cr.setMemento(or.createMemento()); //保存状态
        or.setState("S1");
        System.out.println("新的状态:"+or.getState());
        or.restoreMemento(cr.getMemento()); //恢复状态
        System.out.println("恢复状态:"+or.getState());
    }
}
