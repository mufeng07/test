package com.mufeng.test.base.designerMode.singleton;

/**
 * @Auther: mufeng
 * @Date: 2019/3/7 10:49
 */
public class StarveSingleton {
    private StarveSingleton s=new StarveSingleton();
    private StarveSingleton(){

    }
    public StarveSingleton getInstance(){
        return s;
    }
}
