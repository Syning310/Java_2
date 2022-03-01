package abstract_1;

public class Test
{
    public static void main(String[] args)
    {
//        A a = new A();
//        a.job();
//
//        B b = new B();
//        b.job();

        A a = new A();
        System.out.println("A的job运行时间为 = " + a.calculateTime());

        B b = new B();
        System.out.println("B的job运行时间为 = " + b.calculateTime());

    }


}
