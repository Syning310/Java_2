package tankgame08;

import javax.swing.*;

public class Syning_TankGame extends JFrame
{
    private MyPanel mp;

    public static void main(String[] args)
    {
        Syning_TankGame stg = new Syning_TankGame();



    }

    public Syning_TankGame()
    {
        mp = new MyPanel();

        //将mp放入到Thread，并启动
        Thread thread = new Thread(mp);
        thread.start();

        this.add(mp);
        this.setSize(1200, 950);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addKeyListener(mp);

    }

}
