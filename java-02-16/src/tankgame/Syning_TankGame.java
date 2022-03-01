package tankgame;

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
        this.add(mp);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addKeyListener(mp);

    }

}
