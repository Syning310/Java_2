package final_;

public class Final01
{

}

class Base
{
    public final int add(int a, int b)
    {
        return a + b;
    }
}

class Dev extends Base
{
    //无法重写Base中的final修饰的方法
//    public final int add(int a, int b)
//    {
//        return a - b;
//    }

    //但可以重载
    public int add()
    {
        return 1;
    }

}
