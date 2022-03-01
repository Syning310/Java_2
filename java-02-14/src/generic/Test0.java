package generic;

import java.util.ArrayList;

public class Test0
{
    public static void main(String[] args)
    {
        //编写程序，在ArrayList中，添加3个Dog对象，Dog含有name和age，并输出name和age
        ArrayList alt = new ArrayList();
        alt.add(new Dog0("黄", 20));
        alt.add(new Dog0("白", 14));


        //如果不小心添加进了一只猫
        alt.add(new Cat0("尘", 8));


        for (Object o : alt)
        {
            //那么在这里向下转型的时候，就会抛出异常，猫不是狗
            System.out.println(((Dog0)o).getName() + "   " + ((Dog0)o).getAge());
        }


    }
}

class Dog0
{
    private String name;
    private int age;

    public String toString()
    {
        return "name: " + name + "  age: " + age;
    }

    public Dog0(String name, int age)
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

    public void setAge(int age)
    {
        this.age = age;
    }
}

class Cat0
{
    private String name;
    private int age;

    public String toString()
    {
        return "name: " + name + "  age: " + age;
    }

    public Cat0(String name, int age)
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

    public void setAge(int age)
    {
        this.age = age;
    }
}
