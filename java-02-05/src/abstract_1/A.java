package abstract_1;


public class A extends Template
{
    public void job()
    {
        long sum = 0;
        for (long i = 0; i < 99999999; ++i)
        {
            sum *= i;
        }
    }




//    public void job()
//    {
//        long start = System.currentTimeMillis();
//        long sum = 0;
//        for (long i = 0; i < 99999999; ++i)
//        {
//            sum += i;
//        }
//        long end = System.currentTimeMillis();
//
//        System.out.println("A job执行时间为: " + (end - start));
//    }

}
