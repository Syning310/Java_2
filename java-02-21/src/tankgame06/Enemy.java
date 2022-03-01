package tankgame06;

import java.util.Vector;

public class Enemy extends Tank implements Runnable
{
    //在敌人坦克类，使用Vector，保存多个Shot
    Vector<Shot> shots = new Vector<>();
    private boolean isLive = true;

    @Override
    public void run()
    {

        while (true)
        {
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
