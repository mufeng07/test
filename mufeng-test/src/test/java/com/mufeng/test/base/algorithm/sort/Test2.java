package com.mufeng.test.base.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: mufeng
 * @Date: 2019/10/10 10:48
 */
public class Test2 {
    @Test
    public void test1(){
        int[] arr=new int[]{1,2,3};
        for(int i=1;i<arr.length;i++){
            int tmp=arr[i];
            int j=i;
            while (j>0&&tmp<arr[j-1]){
                arr[j]=arr[j-1];
                --j;
            }
            if(i!=j)
            arr[j]=tmp;
            System.out.println(Arrays.toString(arr));
        }
    }
}
