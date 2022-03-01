package poly_detail;

public class test01
{
    public static void main(String[] args)
    {
        //父类引用指向子类对象时
        Animal ani = new Dog("捏");

        //访问属性时，得到的字段是编译类型的字段，不会从子类区域开始查找
        System.out.println("ani.age = " + ani.age);  //age = 100

        //而访问方法时，会先查看子类有没有重写父类的方法，没有的话去父类的区域中查找，并使用方法
        System.out.println("ani.age = " + ani.getAge());  //ani.getAge() = 13

        Cat c = new Cat();
        System.out.println("c.getAge() = " + c.getAge());  //100


    }
}
