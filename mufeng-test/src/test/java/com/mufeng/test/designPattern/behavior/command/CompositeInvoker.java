package com.mufeng.test.designPattern.behavior.command;

import java.util.ArrayList;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/4 14:41
 */
public class CompositeInvoker implements AbstractCommand {
    private ArrayList<AbstractCommand> children = new ArrayList<AbstractCommand>();
    public void add(AbstractCommand c)
    {
        children.add(c);
    }
    public void remove(AbstractCommand c)
    {
        children.remove(c);
    }
    public AbstractCommand getChild(int i)
    {
        return children.get(i);
    }
    public void execute()
    {
        for(Object obj:children)
        {
            ((AbstractCommand)obj).execute();
        }
    }
}
