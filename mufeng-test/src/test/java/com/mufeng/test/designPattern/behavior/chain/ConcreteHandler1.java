package com.mufeng.test.designPattern.behavior.chain;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 15:05
 */
public class ConcreteHandler1 extends Handler {
    public void handleRequest(String request)
    {
        if(request.equals("one"))
        {
            System.out.println("具体处理者1负责处理该请求！");
        }
        else
        {
            if(getNext()!=null)
            {
                getNext().handleRequest(request);
            }
            else
            {
                System.out.println("没有人处理该请求！");
            }
        }
    }
}
