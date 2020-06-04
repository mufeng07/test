package com.mufeng.test.designPattern.behavior.chain;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 15:04
 */
public abstract class Handler {
    private Handler next;
    public void setNext(Handler next)
    {
        this.next=next;
    }
    public Handler getNext()
    {
        return next;
    }
    //处理请求的方法
    public abstract void handleRequest(String request);
}
