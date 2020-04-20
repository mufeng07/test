package com.mufeng.test.base.nio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestNIO3 {
    public static void main(String[] args) {
        String line="how are you12?";
        String pattern="(.*)(\\d+)(.*)";
        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(line);
        if(matcher.find()){
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
        }else{
            System.out.println("no");
        }
    }
}
