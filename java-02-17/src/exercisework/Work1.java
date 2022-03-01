package exercisework;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Work1
{
    public static void main(String[] args)
    {
        T2 t2 = new T2();
        T1 t1 = new T1(t2);

        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);

        th1.start();
        th2.start();



    }
}
class T1 implements Runnable
{
    T2 ts;
    Scanner sc = new Scanner(System.in);
    @Override
    public void run()
    {
        char ch;
        while (true)
        {
            System.out.println("请输入指定(Q-退出) >:");
            ch = sc.next().toUpperCase(Locale.ROOT).charAt(0);
            if (ch == 'Q')
            {
                ts.setLoop(false);
                System.out.println("退出！！！");
                break;
            }
        }
    }

    public T1(T2 ts)
    {
        this.ts = ts;
    }
}

class T2 implements Runnable
{
    boolean loop = true;
    @Override
    public void run()
    {
        Random ran = new Random();
        while (loop)
        {
            System.out.println("随机数： " + ran.nextInt(100));
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }

    }

    public void setLoop(boolean loop)
    {
        this.loop = loop;
    }
}
