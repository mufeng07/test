package com.mufeng.test.designPattern.behavior.state;

/**
 * @description: 环境类
 * @author: mufeng
 * @create: 2020/6/4 15:19
 */
public class ThreadContext {
    private ThreadState state;
    ThreadContext()
    {
        state=new New();
    }
    public void setState(ThreadState state)
    {
        this.state=state;
    }
    public ThreadState getState()
    {
        return state;
    }
    public void start()
    {
        ((New) state).start(this);
    }
    public void getCPU()
    {
        ((Runnable) state).getCPU(this);
    }
    public void suspend()
    {
        ((Running) state).suspend(this);
    }
    public void stop()
    {
        ((Running) state).stop(this);
    }
    public void resume()
    {
        ((Blocked) state).resume(this);
    }
}
