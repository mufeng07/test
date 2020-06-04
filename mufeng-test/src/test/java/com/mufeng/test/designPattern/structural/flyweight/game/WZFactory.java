package com.mufeng.test.designPattern.structural.flyweight.game;

import java.util.ArrayList;

/**
 * @description:
 * @author: mufeng
 * @create: 2020/6/3 17:56
 */
public class WZFactory {
    private ArrayList<ChessPieces> qz;
    public WZFactory()
    {
        qz=new ArrayList<ChessPieces>();
        ChessPieces w=new WhitePieces();
        qz.add(w);
        ChessPieces b=new BlackPieces();
        qz.add(b);
    }
    public ChessPieces getChessPieces(String type)
    {
        if(type.equalsIgnoreCase("w"))
        {
            return (ChessPieces)qz.get(0);
        }
        else if(type.equalsIgnoreCase("b"))
        {
            return (ChessPieces)qz.get(1);
        }
        else
        {
            return null;
        }
    }
}
