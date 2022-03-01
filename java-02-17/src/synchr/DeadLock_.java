package synchr;

public class DeadLock_
{
    public static void main(String[] args) throws InterruptedException
    {
        DeadLockDemo d1 = new DeadLockDemo(true);
        DeadLockDemo d2 = new DeadLockDemo(false);


        d1.start();
        d2.start();
        //d1进入取走了o1的对象锁，d2进入取走了o2的对象锁，此时两条线程会陷入死锁的情况
        //d1持有o1的对象锁但需要o2，d2持有o2的对象锁但需要o1
        //此时d1和d2的状态都是Block

        Thread.sleep(1000);
        System.out.println("d1线程的状态 = " + d1.getState());
        System.out.println("d2线程的状态 = " + d2.getState());



    }
}


class DeadLockDemo extends Thread
{
    static Object o1 = new Object();  //保证多线程，共享一个对象，这里使用static
    static Object o2 = new Object();  //
    boolean flag;

    public DeadLockDemo(boolean flag)
    {
        this.flag = flag;
    }

    @Override
    public void run()
    {
        //1、如果flag为true，X线程就会先获得o1的对象锁，进入o1同步代码块中，打印进入1
        //2、X线程在o1同步代码块中，获得o2的对象锁，进入o2同步代码块，打印进入2
        if (flag)
        {
            synchronized (o1)
            {
                System.out.println(Thread.currentThread().getName() + " --进入1");

                synchronized (o2)
                {
                    System.out.println(Thread.currentThread().getName() + " --进入2");
                }
            }
        }
        else
        {
            synchronized (o2)
            {
                System.out.println(Thread.currentThread().getName() + " --进入3");
                synchronized (o1)
                {
                    System.out.println(Thread.currentThread().getName() + " --进入4");
                }
            }

        }

    }



}
