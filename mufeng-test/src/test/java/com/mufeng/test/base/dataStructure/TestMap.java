package com.mufeng.test.base.dataStructure;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    @Test
    public void test1(){
        Map map=new HashMap();
       String a="ab";
       a.hashCode();
        System.out.println(a);
        System.out.println("a".hashCode());
        System.out.println("b".hashCode());
    }
    @Test
    public void test2(){
        char value[]="a".toCharArray();
        int hash=0;
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
    }
}
