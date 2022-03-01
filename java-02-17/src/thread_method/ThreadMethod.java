package thread_method;

public class ThreadMethod
{
    public static void main(String[] args) throws InterruptedException
    {
        T t = new T();
        t.setName("宁");
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();

        //System.out.println(t.getName());

        //主线程 打印5个hi，然后就中断 t 线程的休眠
        for (int i = 0; i < 5; ++i)
        {
            Thread.sleep(1000);
            System.out.println("hi " + i);
        }

        //当执行这个方法时，就会中断 t 线程的休眠
        t.interrupt();

    }
}


class T extends Thread
{
    @Override
    public void run()
    {
        while (true) {
            for (int i = 0; i < 100; ++i) {
                System.out.println(Thread.currentThread().getName() + " 吃肠粉 -- " + i);
            }

            try {
                System.out.println(Thread.currentThread().getName() + " 休眠中~~~");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                //InterruptedException 是捕获到了一个中断异常，不是终止
                System.out.println(Thread.currentThread().getName() + " 被 interrupt了");
            }
        }

    }
}