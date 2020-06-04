package com.mufeng.test.designPattern.behavior.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 17:51
 */
public class ConcreteAggregate implements Aggregate {
    private List<Object> list=new ArrayList<Object>();
    public void add(Object obj)
    {
        list.add(obj);
    }
    public void remove(Object obj)
    {
        list.remove(obj);
    }
    public Iterator getIterator()
    {
        return(new ConcreteIterator(list));
    }
}
