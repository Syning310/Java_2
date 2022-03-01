package hashset_;

import java.util.HashSet;
import java.util.Objects;

public class Exercise
{
    public static void main(String[] args)
    {

        HashSet hs = new HashSet();
        Person p1 = new Person("宁", 20);
        Person p2 = new Person("颜", 16);
        Person p3 = new Person("宁", 18);
        Person p4 = new Person("宁", 20);  //重复

        System.out.println(ensure(hs.add(p1)));
        System.out.println(ensure(hs.add(p2)));
        System.out.println(ensure(hs.add(p3)));
        System.out.println(ensure(hs.add(p4)));  //不同对象，若是没有重写equals和hashCode；那么可以添加成功

        System.out.println("hs = " + hs);


    }
    static String ensure(boolean b)
    {
        return b ? "添加成功" : "添加失败";
    }
}



class Person
{
    String name;
    int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    public String toString()
    {
        return "name: " + name + ", age: " + age;
    }

    //如果name和age值相同，则返回相同的hash值
    public int hashCode()
    {
        return Objects.hash(name, age);
    }
    //如果name和age相同，则返回true
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Person p = (Person)o;
        return age == p.age && Objects.equals(name, p.name);
    }

}
