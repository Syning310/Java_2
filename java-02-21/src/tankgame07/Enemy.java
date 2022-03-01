package tankgame07;

import java.util.Vector;

public class Enemy extends Tank implements Runnable
{
    //在敌人坦克类，使用Vector，保存多个Shot
    Vector<Shot> shots = new Vector<>();

   //private boolean isLive = true;





    @Override
    public void run()
    {

        while (true)
        {

            //判断如果shots的size为0，说明没有子弹了；那就创建一颗子弹，让入道shots集合中，并启动
            if (isLive && shots.size() < 4)
            {
                Shot s = null;
                //判断坦克的方向，创建对应的子弹
                switch (getDirect())
                {
                    case 0:
                        s = new Shot(getX() + 20, getY(), getDirect());
                        break;
                    case 1:
                        s = new Shot(getX() + 60, getY() + 20, getDirect());
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 60, getDirect());
                        break;
                    case 3:
                        s = new Shot(getX(), getY() + 20, getDirect());
                        break;
                }

                shots.add(s);
                //启动
                new Thread(s).start();
            }


            //根据坦克的方向来继续移动
            switch (getDirect())
            {
                case 0:
                {
                    //让坦克保持一个方向，走30步
                    for (int i = 0; i < 30; ++i)
                    {
                        if (getY() > 0)
                        {
                            moveUp();
                        }
                        //休眠50毫秒
                        try
                        {
                            Thread.sleep(40);
                        }
                        catch (InterruptedException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                }
                case 1:
                {
                    //让坦克保持一个方向，走30步
                    for (int i = 0; i < 30; ++i)
                    {
                        if (getX() + 60 < 1000)
                        {
                            moveRight();
                        }
                        //休眠50毫秒
                        try
                        {
                            Thread.sleep(40);
                        }
                        catch (InterruptedException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                }
                case 2:
                {
                    //让坦克保持一个方向，走30步
                    for (int i = 0; i < 30; ++i)
                    {
                        if (getY() + 60 < 750)
                        {
                            moveDown();
                        }
                        //休眠50毫秒
                        try
                        {
                            Thread.sleep(40);
                        }
                        catch (InterruptedException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                }
                case 3:
                {
                    //让坦克保持一个方向，走30步
                    for (int i = 0; i < 30; ++i)
                    {
                        if (getX() > 0)
                        {
                            moveLeft();
                        }
                        //休眠50毫秒
                        try
                        {
                            Thread.sleep(40);
                        }
                        catch (InterruptedException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                }
            }


            //随机数来改变坦克方向 0 - 3
            setDirect((int)(Math.random() * 4));

            //一定要考虑清除，线程什么时候结束
            if (!isLive())
            {
                //退出线程
                break;
            }
        }

    }

    public Enemy(int x, int y)
    {
        super(x, y);
    }


    public boolean isLive()
    {
        return isLive;
    }
    public void setLive(boolean live)
    {
        isLive = live;
    }
}
