package com.mufeng.test.designPattern.behavior.visitor;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 19:04
 */
public interface Element {
    void accept(Visitor visitor);
}
