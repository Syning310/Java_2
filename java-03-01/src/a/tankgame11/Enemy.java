package a.tankgame11;

import java.util.Vector;

public class Enemy extends Tank implements Runnable
{
    //在敌人坦克类，使用Vector，保存多个Shot
    Vector<Shot> shots = new Vector<>();

    //private boolean isLive = true;

    //增加成员，Enemy可以得到其他坦克的Vector
    Vector<Enemy> ems = new Vector<>();



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
                        if (getY() > 0 && !isTouchTank())
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
                        if (getX() + 60 < 1000 && !isTouchTank())
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
                        if (getY() + 60 < 750  && !isTouchTank())
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
                        if (getX() > 0  && !isTouchTank())
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


    //编写方法，判断当前的这个敌人坦克，是否和其他坦克发生了重叠，或碰撞
    public boolean isTouchTank()
    {
        //判断当前敌人坦克的方向
        switch (getDirect())
        {
            case 0:
            {
                //让当前坦克，和其他所有的敌人坦克比较
                for (int i = 0; i < ems.size(); ++i)
                {
                    //从ems中，取出敌人坦克
                    Enemy e = ems.get(i);

                    //不和自己比较
                    if (e != this)
                    {
                        //如果敌人坦克是上/下    x的范围[e.getX(), e.getX() + 40]
                        //如果敌人坦克是左/右    y的范围[e.getY(), e.getY() + 60]
                        if (e.getDirect() == 0 || e.getDirect() == 2)
                        {
                            if (this.getX() >= e.getX() && this.getX() <= e.getX() + 40 &&
                                    this.getY() >= e.getY() && this.getY() <= e.getY() + 60)
                            {
                                return true;
                            }

                            if (this.getX() + 40 >= e.getX() && this.getX() + 40 <= e.getX() + 40 &&
                                    this.getY() >= e.getY() && this.getY() <= e.getY() + 60)
                            {
                                return true;
                            }

                        }
                        if (e.getDirect() == 1 || e.getDirect() == 3)
                        {
                            if (this.getX() >= e.getX() && this.getX() <= e.getX() + 60 &&
                                    this.getY() >= e.getY() && this.getY() <= e.getY() + 40)
                            {
                                return true;
                            }

                            if (this.getX() + 40 >= e.getX() && this.getX() + 40 <= e.getX() + 60 &&
                                    this.getY() >= e.getY() && this.getY() <= e.getY() + 40)
                            {
                                return true;
                            }
                        }
                    }

                }
            }
                break;
            case 1:
            {
                //让当前坦克，和其他所有的敌人坦克比较
                for (int i = 0; i < ems.size(); ++i)
                {
                    //从ems中，取出敌人坦克
                    Enemy e = ems.get(i);

                    //不和自己比较
                    if (e != this)
                    {
                        if (e.getDirect() == 0 || e.getDirect() == 2)
                        {
                            //左上角
                            if (this.getX() + 60 >= e.getX() && this.getX() + 60 <= e.getX() + 40 &&
                                    this.getY() >= e.getY() && this.getY() <= e.getY() + 60)
                            {
                                return true;
                            }

                            //右下角
                            if (this.getX() + 60 >= e.getX() && this.getX() + 60 <= e.getX() + 40 &&
                                    this.getY() + 40 >= e.getY() && this.getY() + 40 <= e.getY() + 60)
                            {
                                return true;
                            }

                        }

                        if (e.getDirect() == 1 || e.getDirect() == 3)
                        {
                            if (this.getX() + 60 >= e.getX() && this.getX() + 60 <= e.getX() + 60 &&
                                    this.getY() >= e.getY() && this.getY() <= e.getY() + 40)
                            {
                                return true;
                            }

                            if (this.getX() + 60 >= e.getX() && this.getX() + 60 <= e.getX() + 60 &&
                                    this.getY() + 40 >= e.getY() && this.getY() + 40 <= e.getY() + 40)
                            {
                                return true;
                            }
                        }
                    }

                }
            }
                break;
            case 2:
            {
                //让当前坦克，和其他所有的敌人坦克比较
                for (int i = 0; i < ems.size(); ++i)
                {
                    //从ems中，取出敌人坦克
                    Enemy e = ems.get(i);

                    //不和自己比较
                    if (e != this)
                    {
                        if (e.getDirect() == 0 || e.getDirect() == 2)
                        {
                            //左上角
                            if (this.getX() >= e.getX() && this.getX() <= e.getX() + 40 &&
                                    this.getY() + 60 >= e.getY() && this.getY() + 60 <= e.getY() + 60)
                            {
                                return true;
                            }

                            //右下角
                            if (this.getX() + 40 >= e.getX() && this.getX() + 40 <= e.getX() + 40 &&
                                    this.getY() + 60 >= e.getY() && this.getY() + 60 <= e.getY() + 60)
                            {
                                return true;
                            }

                        }

                        if (e.getDirect() == 1 || e.getDirect() == 3)
                        {
                            if (this.getX() >= e.getX() && this.getX() <= e.getX() + 60 &&
                                    this.getY() + 60 >= e.getY() && this.getY() + 60 <= e.getY() + 40)
                            {
                                return true;
                            }

                            if (this.getX() + 40 >= e.getX() && this.getX() + 40 <= e.getX() + 60 &&
                                    this.getY() + 60 >= e.getY() && this.getY() + 60 <= e.getY() + 40)
                            {
                                return true;
                            }
                        }
                    }

                }
            }
                break;
            case 3:
            {
                //让当前坦克，和其他所有的敌人坦克比较
                for (int i = 0; i < ems.size(); ++i)
                {
                    //从ems中，取出敌人坦克
                    Enemy e = ems.get(i);

                    //不和自己比较
                    if (e != this)
                    {
                        if (e.getDirect() == 0 || e.getDirect() == 2)
                        {
                            //左上角
                            if (this.getX() >= e.getX() && this.getX() <= e.getX() + 40 &&
                                    this.getY() >= e.getY() && this.getY() <= e.getY() + 60)
                            {
                                return true;
                            }

                            //右下角
                            if (this.getX() >= e.getX() && this.getX() <= e.getX() + 40 &&
                                    this.getY() + 40 >= e.getY() && this.getY() + 40 <= e.getY() + 60)
                            {
                                return true;
                            }

                        }

                        if (e.getDirect() == 1 || e.getDirect() == 3)
                        {
                            if (this.getX() >= e.getX() && this.getX() <= e.getX() + 60 &&
                                    this.getY() >= e.getY() && this.getY() <= e.getY() + 40)
                            {
                                return true;
                            }

                            if (this.getX() >= e.getX() && this.getX() <= e.getX() + 60 &&
                                    this.getY() + 40 >= e.getY() && this.getY() + 40 <= e.getY() + 40)
                            {
                                return true;
                            }
                        }
                    }

                }
            }
                break;
        }


        return false;
    }


    //提供一个方法，可以将MyPanel对象中的VecEnemy成员取来
    public void setEms(Vector<Enemy> ems)
    {
        this.ems = ems;
    }


    public Enemy(int x, int y)
    {
        super(x, y);
    }

//    public Enemy(int x, int y, int d)
//    {
//        super(x, y, d);
//    }

    public boolean isLive()
    {
        return isLive;
    }
    public void setLive(boolean live)
    {
        isLive = live;
    }
}
