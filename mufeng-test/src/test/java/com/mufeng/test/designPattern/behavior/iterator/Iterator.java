package com.mufeng.test.designPattern.behavior.iterator;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 17:52
 */
public interface Iterator {
    Object first();
    Object next();
    boolean hasNext();
}
