package com.mufeng.test.base.designerMode.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Auther: mufeng
 * @Date: 2019/3/7 10:29
 */
public class CASSingleton {
    private static final AtomicReference<CASSingleton> INSTANCE=new AtomicReference();
    private CASSingleton(){
        System.out.println("初始化了");
        TestCASSingleton.count.getAndIncrement();
    }
    public static CASSingleton getInstance(){
        for(;;){
            CASSingleton casSingleton=INSTANCE.get();
            if(null !=casSingleton){
                return  casSingleton;
            }
            casSingleton=new CASSingleton();
            if(INSTANCE.compareAndSet(null,casSingleton)){
                return casSingleton;
            }
        }
    }
}
