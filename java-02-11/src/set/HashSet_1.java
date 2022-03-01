package set;

import java.util.HashSet;

public class HashSet_1
{
    public static void main(String[] args)
    {
        HashSet hs = new HashSet();

        // HashSet不能添加相同元素/对象
        hs.add("luck");   //ok
        hs.add("luck");   //失败
        hs.add(new Dog("tom"));  //ok
        hs.add(new Dog("tom"));  //ok

        System.out.println("hs = " + hs);

        hs.add(new String("宁"));  //ok
        hs.add(new String("宁"));  //失败
        System.out.println("hs = " + hs);

    }
}


class Dog
{
    private String name;

    public Dog(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name=" + name;
    }
}