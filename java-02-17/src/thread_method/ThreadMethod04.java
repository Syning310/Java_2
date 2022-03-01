package thread_method;

public class ThreadMethod04
{
    public static void main(String[] args) throws InterruptedException
    {
        T4 t4 = new T4();

        //如果希望当主线程结束之后，子线程可以自动结束
        //只需要将子线程设置为守护线程即可
        t4.setDaemon(true);


        //应该先设置成守护线程，再start，否则会出现异常
        t4.start();



        for (int i = 0; i < 5; ++i)
        {
            Thread.sleep(1000);
            System.out.println("嘿嘿嘿  --  " + (i + 1));

        }


    }
}

class T4 extends Thread
{
    @Override
    public void run()
    {
        //无限循环
        for (; ; )
        {
            try
            {
                Thread.sleep(50);  //休眠50毫秒
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("哈哈哈~~~");

        }
    }
}
