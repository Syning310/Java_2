package codeblock;

class Test00
{
    public int a;
    public static int b;

    static{
        System.out.println("Test00 静态初始化块的调用...");
        b = 10;
    }

    {
        a = 10;
        System.out.println("this.a = " + this.a);
        System.out.println("Test00.b = " + Test00.b);
        System.out.println("Test00 普通初始化块的调用...");
    }

    public Test00()
    {
        this.a = 0;
        System.out.println("Test00 构造器的调用...");
        System.out.println("a = " + a);
    }



}

public class Test01 extends Test00
{
    static{
        System.out.println("Test01 静态初始化块的调用...");
    }

    {
        System.out.println("Test01 普通初始化块的调用...");
    }

    public Test01()
    {
        System.out.println("Test01 构造器的调用...");
    }


    public static void main(String[] args)
    {
        new Test01();
    }


}

