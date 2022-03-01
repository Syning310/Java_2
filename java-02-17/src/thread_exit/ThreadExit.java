package thread_exit;

public class ThreadExit
{
    public static void main(String[] args) throws InterruptedException
    {
        T t1 = new T();
        t1.start();

        //如果希望主线程去控制t1线程的终止，修改t1的loop的变量即可
        //在主线程中将t1的loop设置成false，从而终止线程  这叫做 --> 通知方式
        Thread.sleep(10 * 1000);
        t1.setLoop(false);

    }
}


class T extends Thread
{
    //设置一个控制变量
    private boolean loop = true;

    @Override
    public void run()
    {
        int count = 0;
        while (loop)
        {
            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
            System.out.println(Thread.currentThread().getName() + "运行中... -- " + (++count));
        }

    }

    public void setLoop(boolean loop)
    {
        this.loop = loop;
    }
}