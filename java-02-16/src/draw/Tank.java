package draw;

import javax.swing.*;
import java.awt.*;

public class Tank extends JFrame
{
    private BPanel bp;

    public Tank()
    {
        bp = new BPanel();
        this.add(bp);
        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args)
    {
        new Tank();
    }


}

class BPanel extends JPanel
{
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        //g.setFont(new Font("仿宋", Font.BOLD, 10));

        g.setColor(Color.CYAN);
        g.fillRect(40, 40, 10, 40);
        g.fillRect(71, 40, 10, 40);

        g.fillRect(50, 45, 21, 28);

        g.setColor(Color.BLUE);
        g.fillOval(50, 48, 20, 20);

        g.fillRect(58, 25, 5, 25);

    }
}
