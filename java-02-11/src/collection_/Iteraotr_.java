package collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Iteraotr_
{
    @SuppressWarnings ({"all"})
    public static void main(String[] args)
    {
        Collection col = new ArrayList();

        col.add(new Person("宁", 4000));
        col.add(new Person("月", 3000));
        col.add(new Person("颜", 200));
        col.add(new Person("尘", 28));


        System.out.println("col = " + col);

        //使用Iterator遍历
        //先得到 col 集合的对应迭代器
        Iterator it = col.iterator();

        while (it.hasNext())
        {
            //next返回下一个元素，类型时Object
            Object ob = it.next();
            System.out.println(ob);
        }

        //当退出while循环后，这时候it迭代器指向集合中的最后一个元素，如果再执行next会抛出异常
        //如果需要再次遍历，需要重置迭代器
        it = col.iterator();


    }
}

@SuppressWarnings ({"all"})
class Person
{
    private String name;
    private int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}


