package thread_use;

public class Thread02
{
    public static void main(String[] args)
    {
        T2 t2 = new T2();
        Thread trd = new Thread(t2);
        trd.start();

        System.out.println("main线程继续执行");

    }
}

//通过实现Runnable接口，开发线程
class T2 implements Runnable
{
    public void run()
    {
        for (int i = 0; i < 10; ++i)
        {
            System.out.println("hello" + " -- " + i);

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
