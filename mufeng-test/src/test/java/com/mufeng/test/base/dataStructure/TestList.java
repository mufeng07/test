package com.mufeng.test.base.dataStructure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class TestList {
    @Test
    public void test1(){
        List list=new ArrayList();
        list.add("1");
        list.add(2);
        System.out.println(list);
        List vector=new Vector();
        vector.add(23);
        vector.add("re");
        System.out.println(vector);
        List linkedList=new LinkedList();
        linkedList.add(12);
        linkedList.add("34");
        System.out.println(linkedList);
    }
}
