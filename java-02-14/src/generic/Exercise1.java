package generic;

import java.util.ArrayList;
import java.util.Comparator;

public class Exercise1
{
    public static void main(String[] args)
    {

        Employee e1 = new Employee("b", 900, new MyDate(97, 3, 10));
        Employee e2 = new Employee("a", 800, new MyDate(99, 2, 13));
        Employee e3 = new Employee("a", 700, new MyDate(97, 3, 14));

        ArrayList<Employee> al = new ArrayList<>();
        al.add(e1);
        al.add(e2);
        al.add(e3);

        al.sort(new Comparator<Employee>()
                            {
                                @Override
                                public int compare(Employee e1, Employee e2)
                                {
                                    if (e1 == null || e2 == null)
                                    {
                                        return 0;
                                    }

                                    //如此封装性不太好，我们可以把年月日的比较定义在MyDate类中,看MyDate类
                                    if (!(e1.getName().equals(e2.getName())))
                                    {
                                        return e1.getName().compareTo(e2.getName());
                                    }
                                    /*else if (e1.getBirthday().getYear() != e2.getBirthday().getYear())
                                    {
                                        return e1.getBirthday().getYear() - e2.getBirthday().getYear();
                                    }
                                    else if (e1.getBirthday().getMonth() != e2.getBirthday().getMonth())
                                    {
                                        return e1.getBirthday().getMonth() - e2.getBirthday().getMonth();
                                    }
                                    else
                                    {
                                        return e1.getBirthday().getDay() - e2.getBirthday().getDay();
                                    }*/

                                    //让MyDate类继承Comparable，然后实现compareTo
                                    return e1.getBirthday().compareTo(e2.getBirthday());

                                }
                            });

        for (Employee e : al)
        {
            System.out.println(e);
        }



    }
}

class Employee
{
    private String name;
    private int salary;
    private MyDate birthday;

    public String toString()
    {
        return "name: " + name + "\tsalary: " + salary + "\t" + birthday.toString();
    }

    public Employee(String name, int salary, MyDate birthday)
    {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    public String getName()
    {
        return name;
    }

    public int getSalary()
    {
        return salary;
    }

    public MyDate getBirthday()
    {
        return birthday;
    }
}

class MyDate implements Comparable<MyDate>
{
    private int year;
    private int month;
    private int day;

    @Override
    public int compareTo(MyDate md)
    {
        int minus = year - md.getYear();
        if (minus != 0)
        {
            return minus;
        }
        minus = month - md.getMonth();
        if (minus != 0)
        {
            return minus;
        }
        minus = day - md.getDay();
        return minus;
    }

    public String toString()
    {
        return year + "年 " + month + "月 " + day + "日";
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    public MyDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
