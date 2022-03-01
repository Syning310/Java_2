package tankgame03;


//1、定义一个父类的坦克，给后面的各有特点的坦克继承
public class Tank
{
    private int x;  //坦克的横坐标 x
    private int y;  //坦克的纵坐标 y

    private int direct = 0;  //坦克的方向:  0-up  1-left  2-down  3-right
    private int speed = 1;   //坦克速度



    //上右下左 移动方法
    public void moveUp()
    {
        y -= speed;
    }
    public void moveLeft()
    {
        x += speed;
    }
    public void moveDown()
    {
        y += speed;
    }
    public void moveRight()
    {
        x -= speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX()
    {
        return x;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public Tank(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
