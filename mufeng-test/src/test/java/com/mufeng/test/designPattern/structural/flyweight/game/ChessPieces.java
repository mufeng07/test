package com.mufeng.test.designPattern.structural.flyweight.game;

import java.awt.Graphics;
import java.awt.Point;

/**
 * @description: 抽象享元角色：棋子
 * @author: mufeng
 * @create: 2020/6/3 17:50
 */
public interface ChessPieces {
    //下子
    void DownPieces(Graphics g, Point pt);
}
