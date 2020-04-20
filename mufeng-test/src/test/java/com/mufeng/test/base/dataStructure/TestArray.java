package com.mufeng.test.base.dataStructure;

import org.junit.Test;

import java.util.Arrays;

public class TestArray {

    //冒泡排序
    @Test
    public void test1(){
      int[] a={1,-2,3,2,5};
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                int tmp=0;
                if(a[j+1]<a[j]){
                  tmp=a[j];
                  a[j]=a[j+1];
                  a[j+1]=tmp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

}
