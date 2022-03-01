package thread_use;


public class SellTicket
{
    public static void main(String[] args)
    {
//        Thread t1 = new Thread(new Window1());
//        Thread t2 = new Thread((new Window2()));
//        Window3 w3 = new Window3();
//
//        t1.start();
//        t2.start();
//        w3.start();


        //代理的方式
//        Thread t1 = new Thread(new Window1());
//        Thread t2 = new Thread(new Window1());
//        Thread t3 = new Thread(new Window1());
//
//        t1.start();
//        t2.start();
//        t3.start();

        //实现类的方式
        Window3 w31 = new Window3();
        Window3 w32 = new Window3();
        Window3 w33 = new Window3();
        w31.start();
        w32.start();
        w33.start();


        //以上三种方法都会出现超卖现象


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
}

//第一个售票窗口
class Window1 implements Runnable
{
    @Override
    public void run()
    {
        boolean loop = true;
        while (loop)
        {
            if (Ticket.getTicket() <= 0)
            {
                System.out.println("售票结束");
                loop = false;
            }
            Ticket.selTicket();
            System.out.println("售票窗口：" + Thread.currentThread().getName() + " 剩余票 = " + Ticket.getTicket());
            try
            {
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }

    }
}
//第二个售票窗口
class Window2 implements Runnable
{
    @Override
    public void run()
    {
        boolean loop = true;
        while (loop)
        {
            if (Ticket.getTicket() <= 0)
            {
                System.out.println("售票结束");
                loop = false;
            }
            Ticket.selTicket();
            System.out.println("售票窗口：" + Thread.currentThread().getName() + " 剩余票 = " + Ticket.getTicket());
            try
            {
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }

    }
}
//第三个售票窗口
class Window3 extends Thread
{
    @Override
    public void run()
    {
        boolean loop = true;
        while (loop)
        {
            if (Ticket.getTicket() <= 0)
            {
                System.out.println("售票结束");
                loop = false;
            }
            Ticket.selTicket();
            System.out.println("售票窗口：" + Thread.currentThread().getName() + " 剩余票 = " + Ticket.getTicket());
            try
            {
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }

    }
}