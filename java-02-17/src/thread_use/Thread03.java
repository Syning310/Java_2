package thread_use;

public class Thread03
{
    public static void main(String[] args)
    {
        T3 t3 = new T3();
        Thread thread = new Thread(t3);
        thread.start();

        T4 t4 = new T4();
        t4.start();

        for (int i = 0; i < 10; ++i)
        {
            System.out.println("main -- " + i);
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
}

class T3 implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i < 10; ++i)
        {
            System.out.println("hello,线程名： " + Thread.currentThread().getName() + " -- " + i);
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
}

class T4 extends Thread
{
    @Override
    public void run()
    {
        for (int i = 0; i < 5; ++i)
        {
            System.out.println("hi,线程名： " + Thread.currentThread().getName() + " -- " + i);
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
}
