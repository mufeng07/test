package com.mufeng.test.java8tester;

/**
 * @Auther: mufeng
 * @Date: 2018/12/28 18:31
 */
@FunctionalInterface
public interface IGreet {
    void message(String message);
    default void test1(){
        System.out.println(1);
    }
}
