package com.mufeng.test.base.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: mufeng
 * @Date: 2019/9/30 15:55
 */
public class Test1 {
    /**
     * 冒泡排序 O(n²)
     * 算法步骤：
     * 1.比较相邻的两个元素。如果第一个比第二个大，则交换两个元素
     * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 3.针对所有的元素重复以上的步骤，除了最后一个。
     * 4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     */
    @Test
    public void test1(){
        int count=0;
        int[] arr=new int[]{12,9,7,6,4,3};
        for(int j=0;j<arr.length-1;j++){
            for(int i=0;i<arr.length-1-j;i++){
                if(arr[i]>arr[i+1]){
                    count++;
                    int stemp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=stemp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("count:"+count);
    }

    /**
     * 选择排序：
     * 算法步骤：
     * 1.首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     * 2.再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 3.重复第二步，直到所有元素均排序完毕。
     */
    @Test
    public void test2(){
        int count=0;
        int[] arr=new int[]{12,9,7,6,4,3}; //3 9 7 12
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){//2 1
                    count++;
                    min=j;//1 2
                }
            }
            if(i!=min){
                int stemp=arr[i];
                arr[i]=arr[min];
                arr[min]=stemp;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("count:"+count);
    }

    /**
     * 插入排序：
     * 1.将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
     * 2.从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与
     * 有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
     */
    @Test
    public void test3(){
        int count=0;
        int[] arr=new int[]{12,9,7,6,4,3};
        for(int i=1;i<arr.length;i++){
            int tmp=arr[i];//9 7
            int j=i;//1 2
            while (j>0&&tmp<arr[j-1]){
                arr[j]=arr[j-1];//12
                j--;
            }
            if(j!=i){
                arr[j]=tmp;//9
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("count:"+count);
    }

    /**
     * 希尔排序
     * 1.选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
     * 2.按增量序列个数 k，对序列进行 k 趟排序；
     * 3.每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，分别对各子表进行直接插入排序。仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     */
    @Test
    public void test4(){
        int count=0;
        int[] arr=new int[]{12,9,7,6,4,3};
        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("count:"+count);
    }

    /**
     * 归并排序
     * 1.申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
     * 2.设定两个指针，最初位置分别为两个已经排序序列的起始位置；
     * 3.比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
     * 4.重复步骤 3 直到某一指针达到序列尾；
     * 5.将另一序列剩下的所有元素直接复制到合并序列尾。
     */
    @Test
    public void test5(){
        int[] arr=new int[]{12,9,7,6,4,3};
        arr=sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private int[] sort(int[] arr){
        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return merge(sort(left), sort(right));
    }
    protected int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }
}
