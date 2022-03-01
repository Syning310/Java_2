package anonymous_innerclass;


//基于继承类的匿名内部类
public class AnonymousInnerClass_2
{
    public static void main(String[] args)
    {
        new Cat("汤姆").catLook();
    }

}

class Animal
{
    public String name;

    public void look()
    {
        System.out.println("动物看...");
    }

    public Animal() {}
    public Animal(String name)
    {
        this.name = name;
    }
}

class Cat
{
    public String name;

    public void catLook()
    {
        //基于继承类的匿名内部类
        //ani的编译类型是Animal  运行类型是:匿名内部类 Cat$1
        Animal ani = new Animal("动物")
                         {
                             public void look()
                             {
                                 System.out.println("匿名内部类重写了Animal的look方法");
                                 System.out.println("小猫: " + Cat.this.name + "  看见了胡萝卜");
                             }
                         };
        //1、上则代码的底层: class XXX extends Animal {  @Override public void look() {...} }
        //2、jdk底层在第一步创建了匿名内部类之后，立刻就new出一个实例对象，并把地址返回给ani，

        System.out.println("ani.name = " + ani.name);
        ani.look();
        System.out.println("ani.getClass() = " + ani.getClass());

    }

    public Cat(String name)
    {
        this.name = name;
    }

    public Cat() {}
}


