package thread_use;



//通过继承Thread类创建线程
public class Thread01
{
    public static void main(String[] args) throws InterruptedException
    {
        //1、创建一个Cat对象，可以当作线程使用
        Cat cat = new Cat();

        //2、启动线程  ->  最终会执行cat.run()
        cat.start();

        System.out.println("主线程名称： " + Thread.currentThread().getName() + "  继续执行！！！");

        //说明：当main线程启动一个子线程 Thread-0后，主线程不会阻塞，会继续执行
        //此时 主线程和子线程是交替执行
        for (int i = 0; i < 150; ++i)
        {
            System.out.println("主线程 i = " + i);
            //主线程休眠
            Thread.sleep(1000);
        }





    }
}


//1、当一个类继承了Thread类，该类就可以当作线程使用
//2、重写run方法，写上自己的业务代码
//3、run方法是 Thread类实现了 Runnalbe接口的run方法
class Cat extends Thread
{
    //重写run方法，写上自己的业务逻辑
    @Override
    public void run()
    {
        for (int i = 0; i < 105; ++i)
        {
            //该线程每隔一秒，在控制台输出“猫猫，我是小猫咪”
            System.out.println("喵喵，我是小猫咪");

            //线程名
            System.out.println("线程名： " + Thread.currentThread().getName());

            //让该线程休眠一秒
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }



}
