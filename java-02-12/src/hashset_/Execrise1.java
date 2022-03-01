package hashset_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class Execrise1
{
    public static void main(String[] args)
    {
        HashSet hs = new HashSet();

        Employee e1 = new Employee("宁", 2000, new MyDate(1997, 3, 10));
        Employee e2 = new Employee("颜", 2000, new MyDate(1997, 5, 13));
        Employee e3 = new Employee("空", 1900, new MyDate(99, 2, 10));

        Employee e4 = new Employee("宁", 20, new MyDate(1997, 3, 10));


        System.out.println(ensure(hs.add(e1)));
        System.out.println(ensure(hs.add(e2)));
        System.out.println(ensure(hs.add(e3)));
        System.out.println(ensure(hs.add(e4)));


        {
            Iterator it = hs.iterator();
            Employee eee = null;
            while (it.hasNext())
            {
                eee = (Employee)it.next();
                System.out.println(eee);
            }
        }

    }
    static String ensure(boolean b)
    {
        return b ? "添加成功" : "添加失败";
    }
}


class Employee
{
    String name;
    int sal;
    MyDate birthday;

    public String toString()
    {
        return "姓名： " + name + ", 工资: " + sal + ", 生日: " + birthday.year + " 年 " + birthday.month + " 月 " + birthday.day + " 日";
    }

    //根据要求，需要重写hashCode和equals方法
    @Override
    public int hashCode()
    {
        return Objects.hash(name, birthday);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass())
        {
            return false;
        }
        Employee emp = (Employee)obj;
        return this.name == emp.name && Objects.equals(this.birthday, emp.birthday);
    }

    public Employee(String name, int sal, MyDate birthday)
    {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }
}

class MyDate
{
    int year;
    int month;
    int day;

    @Override
    public int hashCode()
    {
        return Objects.hash(year, month, day);
    }
    @Override
    public boolean equals(Object ob)
    {
        if (this == ob)
        {
            return true;
        }
        if (ob == null || ob.getClass() != this.getClass())
        {
            return false;
        }
        MyDate md = (MyDate)ob;
        return this.year == md.year && this.month == md.month && this.day == md.day;
    }

    public MyDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}