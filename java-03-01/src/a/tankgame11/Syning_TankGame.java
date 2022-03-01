package a.tankgame11;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class Syning_TankGame extends JFrame
{
    private MyPanel mp;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {

        Syning_TankGame stg = new Syning_TankGame();
    }

    public Syning_TankGame()
    {
        System.out.print("请选择(1.新游戏 / 2.继续上局)>: ");
        String key = sc.next();

        mp = new MyPanel(Integer.parseInt(key));

        //将mp放入到Thread，并启动
        Thread thread = new Thread(mp);
        thread.start();

        this.add(mp);
        this.setSize(1300, 950);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addKeyListener(mp);


        //在JFrame中，增加响应关闭窗口的处理
        this.addWindowListener(new WindowAdapter()
                                {
                                    public void windowClosing(WindowEvent e)
                                    {
                                        Recorder.keepRecord();
                                        System.exit(0);
                                    }
                                });

    }

}
