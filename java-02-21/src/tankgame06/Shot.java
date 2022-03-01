package tankgame06;

public class Shot implements Runnable
{
    private int x;
    private int y;
    private int direct;
    private int speed = 6;
    private boolean isLive = true;   //子弹是否还存活


    public Shot(int x, int y, int direct)
    {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }

            //根据方向来改变 x，y 的坐标
            switch (direct)
            {
                case 0:  //向上
                    y -= speed;
                    break;
                case 1:  //右
                    x += speed;
                    break;
                case 2:  //下
                    y += speed;
                    break;
                case 3:  //左
                    x -= speed;
                    break;
            }

            //测试，输出x，y的坐标
            //System.out.println("子弹 x = " + x + "  y = " + y);

            //子弹边界；当子弹碰到敌人坦克时，也应该结束线程
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive))
            {
                isLive = false;
                break;
            }

        }


    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean getIsLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

}
