package com.mufeng.test.base.annotation;

public class Session {
    @Token("456")
    public String list(String name){
        return name;
    }
    public String add(String name){
        return name;
    }
}
