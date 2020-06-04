package com.mufeng.test.designPattern.behavior.iterator;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 17:50
 */
public interface Aggregate {
    void add(Object obj);
    void remove(Object obj);
    Iterator getIterator();
}
