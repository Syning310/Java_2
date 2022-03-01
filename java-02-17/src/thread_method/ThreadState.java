package thread_method;

public class ThreadState
{
    public static void main(String[] args) throws InterruptedException
    {
        T5 t5 = new T5();

        System.out.println(t5.getName() + " 状态： " + t5.getState());
        t5.start();

        while (Thread.State.TERMINATED != t5.getState())
        {
            System.out.println(t5.getName() + " 状态： " + t5.getState());
            Thread.sleep(500);
        }

        System.out.println(t5.getName() + " 状态： " + t5.getState());

    }
}

class T5 extends Thread
{
    @Override
    public void run()
    {

            for (int i = 0; i < 10; ++i)
            {
                System.out.println("hi  -- " + (i + 1));

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
