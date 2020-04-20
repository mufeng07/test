package com.mufeng.test.base.designerMode.singleton;

/**
 *
 * @Auther: mufeng
 * @Date: 2019/3/7 11:01
 */
public enum EnumSingleton {
    INSTANCE;
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
