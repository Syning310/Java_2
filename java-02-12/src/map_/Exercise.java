package map_;

import java.util.*;

public class Exercise
{
    public static void main(String[] args)
    {
        Person p1 = new Person("001", "宁", 1200);
        Person p2 = new Person("002", "月", 100);
        Person p3 = new Person("003", "颜", 1100);

        Map map = new HashMap();
        map.put(1, p1);
        map.put(2, p2);
        map.put(3, p3);

        System.out.println("只显示大于1000的Person");

        Set kset = map.keySet();
        for (Object o : kset)
        {
            Person p = (Person)map.get(o);
            if (p.getSalary() > 1000)
            {
                System.out.println(p);
            }
        }


        System.out.println("-----分隔符-----");
        Set enset = map.entrySet();
        Iterator it = enset.iterator();
        while (it.hasNext())
        {
            Map.Entry m = (Map.Entry)it.next();
            Person v = (Person)m.getValue();
            if (v.getSalary() > 1000)
            {
                System.out.println(v);
            }

        }


    }
}


class Person
{
    private String id;
    private String name;
    private int salary;

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name);
    }



    @Override
    public boolean equals(Object o)
    {
        if (this == null)
        {
            return true;
        }
        if (o == null || o.getClass() != this.getClass())
        {
            return false;
        }
        Person p = (Person)o;
        return this.id.equals(p.id) && this.name.equals(p.name);
    }

    public String toString()
    {
        return "姓名: " + name + "  工资: " + salary;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getSalary()
    {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    public Person(String id, String name, int salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
