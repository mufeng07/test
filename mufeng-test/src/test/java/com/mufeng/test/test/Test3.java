package com.mufeng.test.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @Auther: mufeng
 * @Date: 2019/1/28 18:01
 */
public class Test3 {
    public final int a;
    public Test3(){
        this.a=3;
    }

    /**
     * @description: 编写一个程序解决选择问题。令k=N/2,。画出表格显示程序对于N种不同的值的运行时间。
     *  1.审题：从N个数集合中，找出第K大的数的运行时间  N分别取值100000 200000 30000 400000
             例如：{4,2,6,7}  找出第k大的数   k=N/2=2   第2大数就是 6
        2.解题思路：
              1}：数组a大小为N，填充随机数
              2） 临时数组b大小为K，取数组a前k个数，去进行降序排列
              3） 往后的数，跟第k个数c比较，小，舍弃，大，重新排序，去掉第K个数c
              4） 计算耗时
     * @return: void
     * @author: mufeng
     * @time: 2020/4/21 21:40
     */
    @Test
    public void test1(){
       int N=40000;
       int[] a=creatArray(N);
        System.out.println(Arrays.toString(a));
        int kMax = getKMax(a, N/2);
        System.out.println(kMax);
    }
    public int[] creatArray(int N){
        int[] a=new int[N];
        for(int i=0;i<N;i++){
            a[i]=new Random().nextInt(100);
        }
        return a;
    }
    public int getKMax(int[] a,int K){
        long start=new Date().getTime();
        int[] b=new int[K];
        int kMax;
        for(int i=0;i<a.length;i++){
            int temp = a[i];
            if(i == 0){//模仿插入排序，保证其中新数组中必定含有1个元素
                b[i] = temp;
                continue;
            }
            if(i<K){
                b[i]=temp;
                //插入排序
                for(int j=i-1;j>=0&&b[j+1]>b[j];j--){
                        int tmp=b[j];
                        b[j]=b[j+1];
                        b[j+1]=tmp;
                }
            }else{
                //如果往后的数大于第K个数，则与第K个数互换，再进行排序（倒序）；小于等于，则跳过。
                if(temp>b[K-1]){
                    b[K-1]=temp;
                    for(int j=K-1;j>0&&b[j]>b[j-1];j--){
                            int tmp=b[j-1];
                            b[j-1]=b[j];
                            b[j]=tmp;
                    }
                }else{
                    continue;
                }
            }
        }
        long end = new Date().getTime();
        System.out.println("运行时间："+(end-start)+"ms");
        System.out.println(Arrays.toString(b));
        return b[K-1];
    }
    @Test
    public void test2(){
        Random random = new Random();
        int i = random.nextInt(100);
        System.out.println(i);
    }
    /**
     * @description: 问题描述：输入是由一些字母和单词构成的二维数组，目标是找出字谜中的单词，这些单词可以是水平、垂直或沿对角线以任何方向放置。
     *   编写一个程序求解字谜游戏问题
     *   t h i s     找出 this、two、fat、that
     *   w a t s
     *   o a h g
     *   f g d t
         分析：方向有8种
              1从左到右 2从右到左
              3从上到下  4从下到上
              5从左上到右下 6从右下到左上
              7从左下到右上 8从右上到坐下
            已经头皮发麻
     * @return: void
     * @author: mufeng
     * @time: 2020/4/25 10:37
     */
    @Test
    public void test3(){
        String[] words={"this","two","fat","that","dgf"};
        char[][] two_dimensional_char={{'t','h','i','s'},{'w','a','t','s'},{'o','a','h','g'},{'f','g','d','t'}};
        findWords(two_dimensional_char,words);
    }

    private void findWords(char[][] two_dimensional_char, String[] words) {
        //1从左到右
        //2从右到左
        for(int x=0;x<two_dimensional_char.length;x++){
            StringBuilder lr=new StringBuilder();
            StringBuilder rl=new StringBuilder();
            //1从左到右
            for(int y=0;y<two_dimensional_char[x].length;y++){
                lr.append(two_dimensional_char[x][y]);
            }
            //2从右到左
            for(int y=two_dimensional_char[x].length-1;y>=0;y--){
                rl.append(two_dimensional_char[x][y]);
            }
            for(int i=0;i<words.length;i++){
                //1从左到右
                if(lr.toString().contains(words[i])){
                    System.out.print(words[i]);
                    int i1 = lr.toString().indexOf(words[i]);
                    for(int z=i1;z<words[i].length();z++){
                        System.out.print("["+x+","+z+"]");
                    }
                    System.out.println();
                }
                //2从右到左
                if(rl.toString().contains(words[i])){
                    System.out.print(words[i]);
                    int i1 = rl.toString().indexOf(words[i]);
                    for(int z=rl.length()-1-i1;z>=0;z--){
                        System.out.print("["+x+","+z+"]");
                    }
                    System.out.println();
                }
            }
        }
       //5从左上到右下 6从右下到左上（简单）
        //7从左下到右上 8从右上到坐下（简单）
        //3从上到下  4从下到上
        // 对角线翻转，打印需要旋转之前的
        tochar(two_dimensional_char);
    }
    public char[][] tochar(char[][] chars){
        char[][] toarr=new char[chars.length][chars.length];
        int k=0;
        for(char[] x:chars){
            for(int i=0;i<x.length;i++){
                toarr[i][k]= chars[k][i];
            }
            k++;
        }
        return toarr;
    }

    @Test
    public void test4(){
        int fat = "afat".indexOf("fat");
        System.out.println(fat);
    }
    @Test
    public void test5(){
        char[][] two_dimensional_char={{'t','h','i','s'},{'w','a','t','s'},{'o','a','h','g'},{'f','g','d','t'}};
        char[][] tochar = tochar(two_dimensional_char);
        for(int i=0;i<tochar.length;i++){
            for(int j=0;j<tochar.length;j++){
                System.out.print(tochar[i][j]+" ");
            }
            System.out.println();
        }
    }

}
