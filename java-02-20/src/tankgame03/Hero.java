package tankgame03;


//2、定义Hero坦克
public class Hero extends Tank
{
    public Hero(int x, int y)
    {
        super(x, y);
    }

    private Shot shot;  //定义一个Shot对象，表示一个射击(线程)

    //开火
    public void shotEnemy()
    {
        //创建Shot对象(线程)，根据当前Hero对象的位置和方向来创建
        switch (getDirect())  //坦克的方向
        {
            case 0:    //上
                shot = new Shot(getX() + 20, getY(), getDirect());
                break;
            case 1:    //右
                shot = new Shot((getX() + 60), (getY() + 20), getDirect());
                break;
            case 2:    //下
                shot = new Shot(getX() + 20, getY() + 60, getDirect());
                break;
            case 3:    //左
                shot = new Shot(getX(), getY() + 20, getDirect());
                break;
        }

        //启动Shot线程
        new Thread(shot).start();

    }

    public Shot getShot()
    {
        return shot;
    }
}
