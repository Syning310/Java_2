package draw;

import javax.swing.*;
import java.awt.*;

//继承JFrame对应窗口,可以理解成一个画框
public class DrawCircle extends JFrame
{
    //1、定义一个面板
    private MyPanel mp;


    public DrawCircle()
    {
        //2、初始化面板
        mp = new MyPanel();

        //3、把面板放入到窗口(画框)
        this.add(mp);

        //4、设置窗口的大小
        this.setSize(400, 300);

        //5、可视化
        this.setVisible(true);

        //6、当点击窗口的叉号，程序就完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args)
    {
        new DrawCircle();



    }
}

//定义一个面板 MyPanel ,继承JPanel类，画图形，就在面板上
class MyPanel extends JPanel
{
    //绘图方法
    //1、MyPanel 对象就是一个画板
    //2、Graphics g 就是画笔
    //3、Graphics 提供了很多绘图的方法
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);  //调用父类的方法完成初始化
        //画出一个圆形
        g.drawOval(50, 50, 100, 100);
    }
}
