package poly_detail;

public class test02
{
    public static void main(String[] args)
    {
        Animal ani = new Animal();
        Cat c = new Cat();

        System.out.println("c instanceof Animal = " + (c instanceof Animal));       //true

        System.out.println("ani instanceof Cat = " + (ani instanceof Cat));         //false

        Animal aa = new Dog();
        //aa的编译类型是Animal   aa的运行类型是Dog
        System.out.println("aa instanceof Animal = " + (aa instanceof Animal));     //true

        System.out.println("aa instanceof Dog = " + (aa instanceof Dog));           //true

        System.out.println("ani instanceof Animal = " + (ani instanceof Animal));   //true


        Object obj = null;
        //因为obj指向空，所以运行类型为空
        System.out.println("obj instanceof Object = " + (obj instanceof Object));   //false

        obj = new Object();
        System.out.println("obj instanceof Object = " + (obj instanceof Object));   //true

    }
}
