package com.mufeng.test.test;

import org.apache.commons.collections.map.LinkedMap;
import org.junit.Test;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: mufeng
 * @Date: 2019/3/13 16:34
 */
public class Test5 {
    @Test
    public void test1(){
      Pattern p=Pattern.compile("aabb");
        System.out.println(p);
        Matcher bbcc = p.matcher("bbcc");
        System.out.println(bbcc.matches());
        Map map=new LinkedMap();

    }
    public boolean match(String pattern,String str){
        String[] s = str.split(" ");
        if(s.length<=0||s.length!=pattern.length()){
            return false;
        }
        String m=oper(s);
        return false;
    }

    private String oper(String[] s) {

        return null;
    }

}
