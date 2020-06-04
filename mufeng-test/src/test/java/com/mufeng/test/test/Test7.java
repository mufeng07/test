package com.mufeng.test.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @author mufeng
 * @date 0:17 2020/4/21
 */
public class Test7 {
    @Test
    public void test1(){
        int size = 10000;
        int[] array = createArray(size);
        System.out.println(Arrays.toString(array));
        int max = getMaxByIndex(array,size/2);
        System.out.println(max);
    }
    public static int getMaxByIndex(int[] array , int index){
        long startTime = new Date().getTime();
        int[] dataArray = new int[index];//用于保存 最小到第k大的数组，简称缓冲数组。
        int dataArrayMax ;//接受缓存数组中最大的数

        for (int i = 0; i < array.length ; i++) {
            int temp = array[i];
            if(i == 0){//模仿插入排序，保证其中新数组中必定含有1个元素
                dataArray[i] = temp;
                continue;
            }
            if(i < index){//在缓冲数组被填充满之前，先进行数据填充,并且在每次填充时，排好顺序
                dataArray[i] = temp;
                for(int j = i ;j>0 && dataArray[j]<dataArray[j-1];j--){
                    int tmp = dataArray[j];
                    dataArray[j]= dataArray[j-1];
                    dataArray[j-1] = tmp;
                }
                continue;
            }else {//此时，缓冲数组中已被填充满，每次遍历到新数据时，进行判断
                dataArrayMax = dataArray[index-1];
                //比缓存数组中的最大值大，就舍弃
                if (temp >=dataArrayMax){
                    continue;
                }else{
                    //遍历缓冲数组，找到当前数值需要插入的位置
                    for (int j = 0; j < index; j++) {
                        int number = dataArray[j];
                        if(number>=temp){
                            //找到了新数字需要插入的下标，此时将该下标后的所有数字向后移
                            for (int k = index-2;k>=j;k--){
                                int currentNumber = dataArray[k];
                                dataArray[k+1] = currentNumber;
                            }
                            dataArray[j] = temp;
                            break;
                        }
                    }
                }

            }

        }
        long endTime = new Date().getTime();
        System.out.println("耗时："+(endTime-startTime)+"ms");
        System.out.println(Arrays.toString(dataArray));
        System.out.println(dataArray.length);
        return dataArray[index-1];
    }

    /**
     * 交换数字位置，用于简化插入排序算法
     * @param array
     * @param x
     * @param y
     */
    public static  void swap(int[] array,int x,int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }




    /**
     * 根据数组长度生成新的数组
     * @param size 数组长度
     */
    public static int[] createArray(int size){
        int[]  array = new int[size];
        for (int i = 0 ;i<size ;i++){
            int random = new Random().nextInt(10);
            array[i] = random;
        }
        return  array;
    }
    @Test
    public void test2(){
        for(int i=1;i<10;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+"x"+j+"="+(i*j)+" ");
            }
            System.out.println();
        }
    }
}
