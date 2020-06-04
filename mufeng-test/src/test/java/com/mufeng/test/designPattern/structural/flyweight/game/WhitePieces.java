package com.mufeng.test.designPattern.structural.flyweight.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @description: 具体享元角色：白子
 * @author: mufeng
 * @create: 2020/6/3 17:53
 */
public class WhitePieces implements ChessPieces {
    public void DownPieces(Graphics g, Point pt)
    {
        g.setColor(Color.WHITE);
        g.fillOval(pt.x,pt.y,30,30);
    }
}
