package exercise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Work2
{
    public static void main(String[] args)
    {

        Map m = new HashMap();

        m.put("jack", 650);
        m.put("tom", 120);
        m.put("smith", 2900);

        System.out.println("m = " + m);

        m.put("jack", 2600);
        m.put("jack", 2600 + 100);
        m.put("tom", 120 + 100);
        m.put("smith", 2900 + 100);
        System.out.println("m = " + m);

        System.out.println("-----getKey-----");
        Set ey = m.entrySet();
        for (Object obj : ey)
        {
            System.out.println(((Map.Entry)obj).getKey());
        }

        System.out.println("-----getValue-----");
        Iterator it = m.keySet().iterator();
        while (it.hasNext())
        {
            System.out.println(m.get(it.next()));
        }


    }
}

//class Employee
//{
//    private String name;
//    private int salary;
//
//    public String getName()
//    {
//        return name;
//    }
//
//    public void setName(String name)
//    {
//        this.name = name;
//    }
//
//    public int getSalary()
//    {
//        return salary;
//    }
//
//    public void setSalary(int salary)
//    {
//        this.salary = salary;
//    }
//
//    public Employee(String name, int salary)
//    {
//        this.name = name;
//        this.salary = salary;
//    }
//}
