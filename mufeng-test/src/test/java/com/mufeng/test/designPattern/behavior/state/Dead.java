package com.mufeng.test.designPattern.behavior.state;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 15:25
 */
public class Dead extends ThreadState {
    public Dead()
    {
        stateName="死亡状态";
        System.out.println("当前线程处于：死亡状态.");
    }
}
