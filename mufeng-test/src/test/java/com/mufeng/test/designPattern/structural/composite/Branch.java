package com.mufeng.test.designPattern.structural.composite;

import java.util.ArrayList;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/3 18:29
 */
public class Branch implements Component {
    private ArrayList<Component> children=new ArrayList<Component>();
    public void add(Component c)
    {
        children.add(c);
    }
    public void remove(Component c)
    {
        children.remove(c);
    }
    public Component getChild(int i)
    {
        return children.get(i);
    }
    public void operation()
    {
        for(Object obj:children)
        {
            ((Component)obj).operation();
        }
    }
}
