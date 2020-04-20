package com.mufeng.test.game.gobang;

import javax.swing.*;
import java.awt.*;

/**
 * @Auther: mufeng
 * @Date: 2019/4/15 11:48
 */
public class GoBangPanel extends JPanel implements GoBangInterface {
    public void gobang()
    {
        //设置版面
        JFrame frame = new JFrame();
        frame.setTitle("五子棋");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        frame.setSize(850,700);
        //设置布局
        frame.setLayout(new BorderLayout());

        frame.add(this,BorderLayout.CENTER);
        //在jpanel组件上画棋子
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.DARK_GRAY);
        panel1.setPreferredSize(new Dimension(150,0));
        frame.add(panel1,BorderLayout.EAST);

        frame.setVisible(true);

        GoBangListener listener = new GoBangListener(this);
        this.addMouseListener(listener);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D gg = (Graphics2D) g;
        //画出整个棋盘
        for(int i = 0; i < Row; i++)//行
        {
            gg.drawLine(X, Y+i*Size, X+Size*(Coloum-1), Y+i*Size);
        }
        for(int i = 0; i < Coloum; i++)//列
        {
            gg.drawLine(X+i*Size, Y, X+i*Size, Y+Size*(Row-1));
        }
        //画出棋子
        for(int i = 0; i < array.length; i++)
            for(int j = 0; j < array[i].length; j++)
            {
                if(array[i][j] != 0)
                {
                    if(array[i][j]%2 != 0)
                    {
                        gg.setColor(Color.black);
                    }else
                    {
                        gg.setColor(Color.white);
                    }
                    int x = Y+j*Size-Size/2;
                    int y = X+i*Size-Size/2;
                    gg.fillOval(x, y, Size, Size);
                }
            }
    }

}
