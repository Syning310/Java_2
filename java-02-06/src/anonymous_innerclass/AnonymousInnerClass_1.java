package anonymous_innerclass;

//基于实现接口的匿名内部类

public class AnonymousInnerClass_1
{
    public static void main(String[] args)
    {
        new Person().myLook();

    }
}


interface AI
{
    void look();
}

class Person
{
    private String name;

    //基于实现接口的匿名内部类
    //实现AI的look类   -传统方法是定义一个class，然后重写look  -->  如果只是需要使用一次，那么特意定义一个类不划算
    //                -可以使用匿名内部类来简化开发
    public void myLook()
    {
        //lokDog的编译类型是AI，运行类型是 匿名内部类：Person$1
        AI lokDog = new AI()
                        {
                            public void look()
                            {
                                System.out.println("看见了小狗...");
                            }
                        };
        //1、上则代码的底层为： class XXX implements AI { public void look(){....} };
        //XXX jvm给了个名字是 (外部类名 + $1) 也就是Person$1
        //2、jdk底层在第一步创建了个匿名内部类类之后，立马就new出它的对象，并返回地址给lokDog (一个对象只能返回一次，所以叫匿名内部类)

        lokDog.look();
        System.out.println("lokDog的运行类型是: " + lokDog.getClass());
    }


    public void introduce()
    {
        System.out.println("My name is " + this.name);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Person() { }

    public Person(String name)
    {
        this.name = name;
    }
}

class Dog implements AI  //如只需使用一次。那么这个非常不划算
{
    public void look()
    {
        System.out.println("看见了小狗");
    }
}






