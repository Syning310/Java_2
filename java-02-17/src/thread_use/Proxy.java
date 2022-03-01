package thread_use;


//这里模拟了Thread的代理模式

//把这个Proxy当成Thread
public class Proxy implements Runnable
{
    private Runnable target;

    @Override
    public void run()
    {
        if (target != null)
        {
            target.run();
        }
    }

    public Proxy(Runnable target)
    {
        this.target = target;
    }

    public void start()
    {
        start0();  //这个方法是真正实现多线程的方法
    }

    //因为只有Thread的start0才有JVM底层调用start0的机制，所以这里只是模拟代理模式，并不是真正的多线程
    public void start0()
    {
        run();
    }

}

class Dog implements Runnable
{

    public static void main(String[] args)
    {
        Dog d = new Dog();
        Proxy p = new Proxy(d);
        p.start();
        for (int i = 0; i < 10; ++i)
        {
            System.out.println("程序继续执行！！！");
        }

    }

    @Override
    public void run()
    {
        for (int i = 0; i < 10; ++i)
        {
            System.out.println("hi" + i);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {

            }
        }

    }
}
