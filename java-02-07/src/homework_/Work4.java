package homework_;

public class Work4
{
    public static void main(String[] args)
    {
        new A().test();
    }
}


class A
{
    private final String name = "颜";
    public void test()
    {
        class B
        {
            private final String name = "宁";
            public void show()
            {
                B b = new B();
                System.out.println("局部内部类的私有常量name = " + b.name);
                System.out.println("外部类的私有常量name = " + A.this.name);
            }
        }

        new B().show();

    }

}
