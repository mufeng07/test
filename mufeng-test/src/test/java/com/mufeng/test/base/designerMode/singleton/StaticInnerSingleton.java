package com.mufeng.test.base.designerMode.singleton;

/**
 * 静态内部类实现单例
 * @Auther: mufeng
 * @Date: 2019/3/7 11:05
 */
public class StaticInnerSingleton {
    public static StaticInnerSingleton getInstance(){
        return InnerSingleton.getInstance();
    }
    private static class InnerSingleton{
        private static StaticInnerSingleton s=new StaticInnerSingleton();
        private InnerSingleton(){}
        public static StaticInnerSingleton getInstance(){
            return s;
        }
    }
}
