package draw;

import javax.swing.*;
import java.awt.*;

public class Demo_Draw extends JFrame
{
    private APanel ap;  //定义一个画板

    public Demo_Draw()
    {
        ap = new APanel();  //初始化画板

        this.add(ap);  //把画板放入到窗口中

        this.setSize(400, 600);  //设置窗口大小

        this.setVisible(true);  //可视化

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static void main(String[] args)
    {
        new Demo_Draw();
    }
}

class APanel extends JPanel
{

    public void paint(Graphics g)
    {
        super.paint(g);

        //1、直线
        //g.drawLine(30, 40, 100, 70);

        //2、矩形边框
        //g.drawRect(30, 50, 100, 100);

        //3、椭圆边框
        //g.drawOval(30, 40, 80, 180);

        //4、填充矩形  -- 首先设置画笔颜色
        //g.setColor(Color.BLUE);
        //g.fillRect(100, 100, 100, 200);

        //5、填充椭圆  --首先设置画笔颜色
        //g.setColor(Color.PINK);
        //g.fillOval(60, 70, 90, 90);

        //6、画图片  --首先获取图片资源
        //6.1、获取图片资源，/西.jpg 表示在该项目的根目录去获取 /西.jpg 图片资源
        //Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/西.jpg"));
        //g.drawImage(image, 0, 0, 1920, 1080, this);

        //7、画字符串  --可以设置画笔颜色和字体
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("仿宋", Font.BOLD, 100));
        g.drawString("宁", 100, 200);


    }


}


