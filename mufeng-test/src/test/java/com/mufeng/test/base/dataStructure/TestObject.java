package com.mufeng.test.base.dataStructure;

import org.junit.Test;

public class TestObject {
    @Test
    public void test1(){
        Person p1=new Person("wang");
        Person p2=new Person("wang");
        Object o1=p1;
        System.out.println(p1.equals(p2));
        System.out.println(p1==p2);
        System.out.println(o1==p1);
        System.out.println(p1.hashCode()+":"+p2.hashCode()+":"+o1.hashCode());
    }

}

class Person{
    String name;
    int age;
    public Person(String name){
        this.name=name;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        if(this==obj){
            return true;
        }
        if(getClass()!=obj.getClass()){
            return false;
        }
        Person other=(Person)obj;
        if(name.equals(other.name)){
            return true;
        }
        return false;
    }
}
