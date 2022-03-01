package static_innerclass;

public class StaticInnerClass
{
    public static void main(String[] args)
    {
        //Person p = new Person("宁");
        //p.test();

        //外部其他类使用静态内部类
        //方法一
        Person.Head h = new Person.Head();
        h.say();

        //方法二
        Person.Head ph = new Person("月").getStaticInstance();
        ph.say();

        Person.Head ppp = Person.getStaticHeadInstance();

    }
}

class Person
{
    private String name;
    private static int eyeNum = 2;

    //这种非静态的方法需要创建实例
    public Head getStaticInstance()
    {
        return new Head();
    }

    //这种静态方法就不需要创建实例，只需要类加载
    public static Head getStaticHeadInstance()
    {
        return new Head();
    }

    public Person(String name)
    {
        this.name = name;
    }

    public void cal()
    {
        System.out.println("Person的普通cal方法");
    }

    public static void stCall()
    {
        System.out.println("Person的静态stCall方法");
    }

    public static class Head
    {

        public void say()
        {
            System.out.println("Person有 " + Person.eyeNum + " 个眼睛");
            //System.out.println(Person.this.name);    //静态内部类，只能访问外部类的静态属性，不能访问非静态属性
            //Person.this.cal();   //静态内部类无法访问外部类的非静态方法

            Person.stCall();      //静态内部类，可以访问外部类的静态方法
        }
    }

    public void test()
    {
        Head h = new Head();
        h.say();
    }





}



