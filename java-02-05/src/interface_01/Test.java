package interface_01;

public class Test
{
    public void work(Inter0 it)
    {
        it.hello();
        it.hi();
    }
    public static void main(String[] args)
    {
        Inter0.test();  //静态方法，可以直接使用
        System.out.println("Inter0.n1 = " + Inter0.n1);

        A a = new A();

        Test tt = new Test();

        tt.work(a);

    }
}
