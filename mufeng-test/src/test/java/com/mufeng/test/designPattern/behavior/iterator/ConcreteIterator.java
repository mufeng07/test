package com.mufeng.test.designPattern.behavior.iterator;

import java.util.List;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 17:52
 */
public class ConcreteIterator implements Iterator {
    private List<Object> list=null;
    private int index=-1;
    public ConcreteIterator(List<Object> list)
    {
        this.list=list;
    }
    public boolean hasNext()
    {
        if(index<list.size()-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Object first()
    {
        index=0;
        Object obj=list.get(index);;
        return obj;
    }
    public Object next()
    {
        Object obj=null;
        if(this.hasNext())
        {
            obj=list.get(++index);
        }
        return obj;
    }
}
