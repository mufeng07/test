package com.mufeng.test.game.gobang;

/**
 * @Auther: mufeng
 * @Date: 2019/4/15 11:46
 */
public interface GoBangInterface {
    //棋子的大小
    public static final int Size = 44;
    public static final int X = 25;
    public static final int Y = 25;
    public static final int Row = 15;
    public static final int Coloum = 15;
    //存旗子的数组
    public static final int[][] array = new int[Row][Coloum];
}
