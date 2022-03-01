package hashset_;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class LinkedHashSet_
{
    public static void main(String[] args)
    {
        Set set = new LinkedHashSet();

        set.add(new String("AA"));
        set.add(456);
        set.add(456);  //失败
        set.add(new Customer("宁", 20));
        set.add(123);
        set.add("SYN");
        set.add(new Customer("宁", 20));
        set.add(new Customer("宁", 20));

        Iterator it = set.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }

    }
}
class Customer
{
    String name;
    int age;

    public Customer(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(name, age);
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || o.getClass() != this.getClass())
        {
            return false;
        }
        return this.age == ((Customer)o).age && this.name.equals(((Customer)o).name);
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
