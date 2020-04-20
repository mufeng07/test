package com.mufeng.test.base.designerMode.singleton;

/**
 * @Auther: mufeng
 * @Date: 2019/3/7 10:36
 */
public class LazySingleton {
    private static LazySingleton s=null;
    private LazySingleton(){

    }
    public static LazySingleton getInstance(){
        if(s==null){
            s=new LazySingleton();
        }
        return s;
    }
    //多线程下
    public static synchronized LazySingleton getInstance1(){
        if(s==null){
            s=new LazySingleton();
        }
        return s;
    }
    //双重检验锁
    private static Object initLock=new Object();
    public static LazySingleton getInstance2(){
        if(s==null){
            synchronized (initLock){
                if(s==null){
                    s=new LazySingleton();
                }
            }
        }
        return s;
    }
}
