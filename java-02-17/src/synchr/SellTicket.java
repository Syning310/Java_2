package synchr;


public class SellTicket
{
    public static void main(String[] args)
    {
        Sell1 s1 = new Sell1();
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s1);
        Thread t3 = new Thread(s1);

        t1.start();
        t2.start();
        t3.start();



//        Sell3 sa = new Sell3();
//        Sell3 sb = new Sell3();
//        Sell3 sc = new Sell3();
//
//        sa.start();
//        sb.start();
//        sc.start();


    }
}

//第一个售票窗口
class Sell1 implements Runnable
{
    Object object = new Object();

    private int ticket = 40;   //一共40张票
    public /*synchronized*/ void sellT()
    {

        synchronized (/*this*/ object)
        {
            if (ticket == 0)
            {
                System.out.println("售票结束！！！");
                return;
            }

            System.out.println("售票窗口： " + Thread.currentThread().getName() + "  剩余票 = " + (--ticket));
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public void run()
    {
        while (true)
        {

            sellT();

            if (ticket == 0)
            {
                break;
            }

        }

    }
}



class Ticket
{
    private static int ticket;

    static
    {
        ticket = 40;
    }

    public static void selTicket()
    {
        --ticket;
    }

    public static int getTicket()
    {
        return ticket;
    }

    public static void setTicket(int ticket)
    {
        Ticket.ticket = ticket;
    }


    //static 的锁是加在Ticket.class上面
    public static synchronized void sellTk()
    {
        if (Ticket.getTicket() <= 0)
        {
            System.out.println("售票结束！！！");
            return;
        }
        Ticket.selTicket();
        System.out.println("售票窗口：" + Thread.currentThread().getName() + " 剩余票 = " + Ticket.getTicket());
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

//第三个售票窗口
class Sell3 extends Thread
{


    @Override
    public void run()
    {
        //boolean loop = true;
        while (true)
        {
            Ticket.sellTk();

            if (Ticket.getTicket() <= 0)
            {
                break;
            }

        }

    }
}