package tankgame08;



//炸弹
public class Bomb
{
    int x, y;  //炸弹坐标
    int life = 9;  //炸弹声明周期
    boolean isLive = true;

    public Bomb(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    //减少生命值
    public void lifeDown()
    {
        if (life > 0)
        {
            --life;
        }
        else
        {
            isLive = false;
        }
    }

}

