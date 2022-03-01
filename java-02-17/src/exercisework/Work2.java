package exercisework;

import javax.swing.plaf.SliderUI;

public class Work2
{
    public static void main(String[] args)
    {
        Money m = new Money();
        Tp1 tp1 = new Tp1(m);
        tp1.setName("tp1");
        Tp2 tp2 = new Tp2(m);
        tp2.setName("tp2");

        tp1.start();
        tp2.start();


    }
}

class Money
{
    private int money = 10000;

    //这里的synchronized，默认是this，两个线程都是用同一个Money对象构造，所以争取的是同一把锁
    public synchronized int qukuan(int m)
    {
        money -= m;
        System.out.println("线程： " + Thread.currentThread().getName() + " 取款： " + m + "  剩余余额： " + money);
        return money;
    }

    public int getMoney()
    {
        return money;
    }
}

class Tp1 extends Thread
{
    Money m;
    public Tp1(Money m)
    {
        this.m = m;
    }
    @Override
    public void run()
    {


        while (true)
        {
            if ((m.getMoney()) < 1000)
            {
                System.out.println("余额不足，不能取款了");
                break;
            }
            int e = m.qukuan(1000);
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException ee)
            {
                System.out.println(ee.getMessage());
            }

        }
    }
}
class Tp2 extends Thread
{
    Money m;
    public Tp2(Money m)
    {
        this.m = m;
    }

    @Override
    public void run()
    {
        while (true)
        {
            if (m.getMoney() < 1000)
            {
                System.out.println("余额不足，不能取款了");
                break;
            }
            int e = m.qukuan(1000);
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException ee)
            {
                System.out.println(ee.getMessage());
            }

        }
    }
}
