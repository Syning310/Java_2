package polymorphic;

public class test00
{
    public static void main(String[] args)
    {

        Master mt = new Master("宁");

        Animal ani = new Cat("锅锅");
        Food fd = new Bone("大排骨");

        System.out.println(mt.feed(ani, fd));


        ani = new Dog("小白");
        fd = new Fish("黄花鱼");

        System.out.println(mt.feed(ani, fd));



    }
}
