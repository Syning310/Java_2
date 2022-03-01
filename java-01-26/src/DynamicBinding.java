

class A
{
    public int i = 10;

    public int sum()
    {
        return this.getI() + 10;
    }
    public int sum1()
    {
        return this.i + 10;
    }
    public int getI()
    {
        return this.i;
    }
}

class B extends A
{
    public int i = 20;

//    public int sum()
//    {
//        return this.i + 20;
//    }
    public int getI()
    {
        return this.i;
    }
//    public int sum1()
//    {
//        return this.i + 10;
//    }
}


public class DynamicBinding
{
    public static void main(String[] args)
    {
        A a = new B();
        //如果没有注销子类的sum,sum1，那么结果是：40，30
        //如果注销了子类的sum，那么结果是：30，30
        //如果注销了子类的sum，sum1，那么结果是：30，20

        System.out.println(a.sum());
        System.out.println(a.sum1());

    }
}
