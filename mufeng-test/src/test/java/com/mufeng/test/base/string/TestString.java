package com.mufeng.test.base.string;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: mufeng
 * @Date: 2018/12/28 17:01
 */
public class TestString {
    /**
     * 去重：aabbccaabb->abc
     *
     */
    @Test
    public void test1(){
        String s1="aabbccddjlsjljfljlkdjlajooijidf";
        StringBuilder sb=new StringBuilder();
        List list=new ArrayList();
        char[] chars = s1.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(!list.contains(chars[i])){
                sb.append(chars[i]);
                list.add(chars[i]);
            }
        }
        System.out.println(sb.toString());
    }
    /**
     * 去重：aabbccbbcc->abcbc
     */
    @Test
    public void test2(){
        String s1="aabbccbbcc";
        StringBuilder sb=new StringBuilder();
        int i=0;
        int len=s1.length();
        while (i<len){
            char c=s1.charAt(i);
            sb.append(c);
            i++;
            while(i<len&&s1.charAt(i)==c){
                i++;
            }
        }
        System.out.println(sb.toString());
    }
    /**
     * 验证 org.apache.commons.lang3.StringUtils isEmpty() isBlank()
     */
    @Test
    public void test3(){
        String s1="";
        String s2=null;
        String s3=" ";
        System.out.println(StringUtils.isEmpty(s1));//true
        System.out.println(StringUtils.isEmpty(s2));//true
        System.out.println(StringUtils.isEmpty(s3));//false
        System.out.println(StringUtils.isBlank(s1));//true
        System.out.println(StringUtils.isBlank(s2));//true
        System.out.println(StringUtils.isBlank(s3));//true
    }
}
