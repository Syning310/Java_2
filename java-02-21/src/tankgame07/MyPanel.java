package tankgame07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//3、绘制坦克活动范围
//为了让MyPanel不停的重绘子弹，需要将MyPanel实现Runnable，当作一个线程使用
public class MyPanel extends JPanel implements KeyListener, Runnable
{
    //4、定义Hero坦克
    Hero hero;
    //敌人坦克数量多，可以放入到线程安全的集合中
    Vector<Enemy> vecEnemy;
    //定义一个Vector，用来存放炸弹,挡子弹击中坦克时，就加入一个Bomb对象到bombs集合中
    Vector<Bomb> bombs = new Vector<>();


    //定义三张炸弹的图片，用来显示爆炸效果
    Image im1;
    Image im2;
    Image im3;


    public MyPanel()
    {
        //初始化hero坦克
        hero = new Hero(500, 500);
        hero.setSpeed(10);


        //敌人坦克集合
        vecEnemy = new Vector<>();

        int enemyTankNum = 3;
        for (int i = 0; i < enemyTankNum; ++i)
        {
            Enemy e = new Enemy(100 * (i + 1), 0);
            e.setDirect(2);
            //启动敌人坦克自行移动线程
            new Thread(e).start();

            //给Enemy坦克加入一颗子弹
            Shot st = new Shot(e.getX() + 20, e.getY() + 60, e.getDirect());
            e.shots.add(st);
            //启动shot对象
            new Thread(st).start();

            vecEnemy.add(e);
        }

        //初始化图片对象
        im1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        im2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        im3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //填充矩形，默认黑色，绘制活动范围
        g.fillRect(0, 0, 1000, 750);


        //画坦克 -- 封装方法
        //加上判断，如果我放坦克被击中，死亡，则不画
        if (hero != null && hero.isLive)
        {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        }


        //画敌人坦克;加个判断，当前坦克是否还存活
        for (int i = 0; i < vecEnemy.size(); ++i)
        {
            //取出坦克
            Enemy e = vecEnemy.get(i);

            if (e.isLive())
            {
                //画坦克
                drawTank(e.getX(), e.getY(), g, e.getDirect(), 1);

                //画出敌人坦克的子弹
                for (int j = 0; j < e.shots.size(); ++j)
                {
                    //取出子弹
                    Shot st = e.shots.get(j);
                    //绘制
                    if (st.getIsLive())
                    {
                        g.draw3DRect(st.getX(), st.getY(), 2, 2, false);
                    }
                    else
                    {
                        //子弹已经死亡了，从Vector中移除掉
                        e.shots.remove(st);
                    }
                }
            }

        }

        //如果bombs集合中有对象，就画出
        if (!(bombs.isEmpty()))
        {
            for (int i = 0; i < bombs.size(); ++i)
            {
                //取出炸弹
                Bomb bo = bombs.get(i);
                //根据当前这个bo对象的life值去画对应的图片
                if (bo.life > 6)
                {
                    g.drawImage(im1, bo.x, bo.y, 60, 60, this);
                }
                else if (bo.life > 3)
                {
                    g.drawImage(im2, bo.x, bo.y, 60, 60, this);
                }
                else
                {
                    g.drawImage(im3, bo.x, bo.y, 60, 60, this);
                }
                //让炸弹的life值减少
                bo.lifeDown();
                //如果bo的life为0，就从bombs的集合中删除
                if (bo.life == 0)
                {
                    bombs.remove(bo);
                }
            }

        }


        //画hero射击的子弹
//        if (hero.getShot() != null && hero.getShot().getIsLive())
//        {
//            g.draw3DRect(hero.getShot().getX(), hero.getShot().getY(), 2, 2, false);
//        }

        //将hero的子弹集合shots，遍历取出绘制
        for (int i = 0; i < hero.shots.size(); ++i)
        {
            Shot s = hero.shots.get(i);
            if (s != null && s.getIsLive())
            {
                g.draw3DRect(s.getX(), s.getY(), 2, 2, false);
            }
            else
            {
                //如果s对象已经无效了，就从shots集合中删除
                hero.shots.remove(s);
            }
        }

    }

    //编写方法，画出坦克
    /**
     *
     * @param x  坦克的左上角x坐标
     * @param y  坦克的左上角y坐标
     * @param g  画笔
     * @param direct  坦克方向(上下左右)
     * @param type    坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type)
    {
        //根据不同类型的坦克，设置不同的颜色
        switch (type)
        {
            case 0:  //我方坦克
                g.setColor(Color.cyan);
                break;
            case 1:  //敌方坦克

                g.setColor(Color.yellow);
                break;
        }

        //根据坦克的方向，来绘制对应形状的坦克
        //direct 表示方向(0：向上  1：向右  2：向下  3：向左)
        switch (direct)
        {
            case 0:  //上
            {
                g.fill3DRect(x, y, 10, 60, false);  //左轮子
                g.fill3DRect(x + 30, y, 10, 60, false); //右轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false); //中间矩形

                g.fillOval(x + 10, y + 20, 20, 20);  //圆盖子
                g.drawLine(x + 20, y + 30, x + 20, y);  //炮
                break;
            }
            case 1: //右
            {
                g.fill3DRect(x, y, 60, 10, false);  //上轮子
                g.fill3DRect(x, y + 30, 60, 10, false);  //下轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);  //中间矩形

                g.fillOval(x + 20, y + 10, 20, 20); //圆盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);  //炮筒
                break;
            }
            case 2: //下
            {
                g.fill3DRect(x, y, 10, 60, false);  //左轮子
                g.fill3DRect(x + 30, y, 10, 60, false); //右轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false); //中间矩形

                g.fillOval(x + 10, y + 20, 20, 20);  //圆盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60); //炮
                break;
            }
            case 3: //左
            {
                g.fill3DRect(x, y, 60, 10, false);  //上轮子
                g.fill3DRect(x, y + 30, 60, 10, false);  //下轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);  //中间矩形

                g.fillOval(x + 20, y + 10, 20, 20); //圆盖子
                g.drawLine(x + 30, y + 20, x, y + 20);  //炮筒
                break;
            }
            default:
                break;
        }


    }


    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    //处理 w d s a 方向键
    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_W)
        {
            //改变坦克的方向
            hero.setDirect(0);
            //修改坦克的坐标 y -= 1
            if (hero.getY() > 0)
                hero.moveUp();
        }
        else if(e.getKeyCode() == KeyEvent.VK_D)
        {
            hero.setDirect(1);
            if (hero.getX() + 60 < 1000)
                hero.moveRight();
        }
        else if(e.getKeyCode() == KeyEvent.VK_S)
        {
            hero.setDirect(2);
            if (hero.getY() + 60 < 750)
                hero.moveDown();
        }
        else if(e.getKeyCode() == KeyEvent.VK_A)
        {
            hero.setDirect(3);
            if (hero.getX() > 0)
                hero.moveLeft();
        }

        //如果按下 J 键，就发射子弹  (一颗子弹的情况)
        if (e.getKeyCode() == KeyEvent.VK_J)
        {
//            //判断hero的子弹是否销毁
//            if (hero.getShot() == null || !hero.getShot().getIsLive())
//                hero.shotEnemy();


            //(多颗子弹的情况)
            hero.shotEnemy();

        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }


    @Override
    public void run()  //每100毫秒，重绘区域,不停重绘，子弹就移动了
    {

        while (true)
        {
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }

            //如果我们的坦克可以发射多颗子弹
            //在判断我方子弹是否击中敌人时，就需要把我们的子弹集合中所有子弹，都取出来和敌人的坦克，进行判断
            for (int i = 0; i < hero.shots.size(); ++i)
            {
                Shot s = hero.shots.get(i);

                //判断子弹是否击中了敌人坦克
                if (s != null && s.getIsLive())  //当前我的子弹还存活
                {
                    //遍历敌人所有的坦克
                    for (int j = 0; j < vecEnemy.size(); ++j)
                    {
                        Enemy e = vecEnemy.get(j);
                        hitTank(s, e);
                    }
                }

            }

            //判断敌人坦克的子弹，是否击中我
            hitHero();

            this.repaint();
        }


    }


    //编写方法，判断我方的子弹是否击中敌人坦克;坦克类换为父类，此方法用来判断子弹是否击中坦克
    public void hitTank(Shot s, Tank em)
    {
        //判断s击中坦克

        switch (em.getDirect())
        {
            case 0:
            case 2:  //坦克向上和向下的方向
            {
                if (s.getX() >= em.getX() && s.getX() <= em.getX() + 40 && s.getY() >= em.getY() && s.getY() <= em.getY() + 60)
                {
                    s.setLive(false);
                    em.setLive(false);
                    //创建Bomb对象，加入到bombs集合中
                    Bomb b = new Bomb(em.getX(), em.getY());
                    bombs.add(b);

                    vecEnemy.remove(em);
                }
                break;
            }
            case 1:
            case 3:  //坦克向右和向左的方向
            {
                if (s.getX() >= em.getX() && s.getX() <= em.getX() + 60 && s.getY() >= em.getY() &&s.getY() <= em.getY() + 40)
                {
                    s.setLive(false);
                    em.setLive(false);
                    //创建Bomb对象，加入到bombs集合中
                    Bomb b = new Bomb(em.getX(), em.getY());
                    bombs.add(b);

                    vecEnemy.remove(em);
                }
                break;
            }
        }

    }


    //判断敌人的坦克是否击中我的坦克
    public void hitHero()
    {
        for (int i = 0; i < vecEnemy.size(); ++i)
        {
            //取出敌人坦克
            Enemy e = vecEnemy.get(i);
            //遍历敌人坦克的所有子弹
            for (int j = 0; j < e.shots.size(); ++j)
            {
                //取出子弹
                Shot s = e.shots.get(j);
                //判断shot是否击中我的坦克
                if (hero.isLive && s.getIsLive())
                {
                    hitTank(s, hero);
                }
            }

        }
    }

}
