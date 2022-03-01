package tankgame04;

import java.util.Vector;

public class Enemy extends Tank
{
    //在敌人坦克类，使用Vector，保存多个Shot
    Vector<Shot> shots = new Vector<>();




    public Enemy(int x, int y)
    {
        super(x, y);
    }

}
