package generic;

import java.util.HashMap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Exercies0
{
    public static void main(String[] args)
    {
        HashMap<String, Student> hs = new HashMap<>();

        hs.put("no1", new Student("宁", 20));
        hs.put("no2", new Student("颜", 16));
        hs.put("no3", new Student("尘", 17));

        System.out.println("第一种遍历方法");

        Set<Map.Entry<String, Student>> st = hs.entrySet();

        for (Map.Entry en : st)
        {
            System.out.println(en.getKey() + "   " + en.getValue());
        }

        Iterator<Student> it = hs.values().iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }




    }
}

@SuppressWarnings({"all"})
class Student
{
    private String name;
    private int age;

    public String toString()
    {
        return name + "\t" + age;
    }

    public Student(String name, int age)
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

