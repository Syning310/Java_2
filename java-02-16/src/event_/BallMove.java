package event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame
{
    private MyA ma;
    public static void main(String[] args)
    {
        BallMove bm = new BallMove();
    }

    public BallMove()
    {
        ma = new MyA();

        this.add(ma);
        this.setSize(500, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //窗口JFarme 对象可以监听键盘事件，即可以监听到面板发生的键盘事件
        this.addKeyListener(ma);

    }

}

class MyA extends JPanel implements KeyListener
{
    //为了让小球可以移动，把他的左上角的坐标设置成变量(x, y)
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.fillOval(x, y, 20, 20);

    }


    //有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    //当某个键按下，该方法会触发
    @Override
    public void keyPressed(KeyEvent e)
    {
        //System.out.println((char)e.getKeyCode() + " 键被按下...");

        //根据按下的键，来处理小球的移动(上下左右键)
        if (e.getKeyCode() == KeyEvent.VK_DOWN)  //VK_DOWN就是向下的箭头对应的code
        {
            ++y;
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            --y;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            --x;
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            ++x;
        }

        //让面板重绘
        this.repaint();
    }

    //当某个键松开了，该方法会触发
    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}

