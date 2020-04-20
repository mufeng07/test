package com.mufeng.test.base.designerMode.singleton;

public class Singleton {
    private Singleton(){

    }
    private static class  SingletonFactory{
        private static Singleton instance=new Singleton();
    }
    public Singleton getInstance(){
        return SingletonFactory.instance;
    }
}
