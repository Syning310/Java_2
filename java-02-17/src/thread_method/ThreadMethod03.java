package thread_method;

public class ThreadMethod03
{
    public static void main(String[] args)
    {
        //主线程每隔1秒，输出hi，一共10次
        //当输出5次hi时，启动一个子线程。每隔1秒输出hello。等该线程输出10次hello后，退出
        //主线程继续输出hi，直到结束


        //T3 t3 = new T3();
        Thread th = new Thread(new T3());

        for (int i = 0; i < 10; ++i)
        {
            System.out.println(Thread.currentThread().getName() + "  hi  --  " + (i + 1));

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }

            if (i == 4)
            {
                th.start();  //启动子线程
                try
                {
                    th.join();
                }
                catch (InterruptedException e)
                {
                    System.out.println(e.getMessage());
                }
            }

        }



    }
}


class T3 implements Runnable
{
    @Override
    public void run()
    {

        for (int i = 0 ; i < 10; ++i)
        {
            System.out.println(Thread.currentThread().getName() + "  hello  --  " + (i + 1));

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
