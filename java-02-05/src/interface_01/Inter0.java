package interface_01;

public interface Inter0
{
    //可以有属性 默认用 public static final  这三个关键字修饰
    int n1 = 10;

    //可以有方法
    void hello();

    //jdk8.0之后  可以有默认方法，但必须用 default 来修饰
    default void hi()
    {
        System.out.println("hi Inter0，Inter0的hi方法");
    }

    //jdk8.0之后  可以有静态方法,静态方法不能用 default 来修饰
    public static void test()
    {
        System.out.println("Inter的test...");
    }
}

class A implements Inter0
{
    public void hello()
    {
        System.out.println("hello A，A实现hello方法");
    }




}
