package thread_method;

public class ThreadMethod02
{
    public static void main(String[] args) throws InterruptedException
    {
        //主线程创建一个子线程，每隔1秒输出hello，输出20次
        //主线程每隔1秒输出hi，输出20次
        //要求：两个线程同时执行，当主线程输出5次之后，就让子线程运行完毕，主线程再继续


        T2 t2 = new T2();
        Thread th = new Thread(t2);
        th.start();

        for (int i = 0; i < 20; ++i)
        {
            System.out.println(Thread.currentThread().getName() + "-- hi -- " + (i + 1));

            if (i == 4)
            {
                th.join();
            }

                Thread.sleep(1000);

        }



    }

}


class T2 implements Runnable
{
    @Override
    public void run() {
        for (int i = 0; i < 20; ++i){
            System.out.println(Thread.currentThread().getName() + " -- hello -- " + (i + 1));

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }

        }
    }
}
