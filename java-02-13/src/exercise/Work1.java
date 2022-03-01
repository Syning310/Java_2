package exercise;

import java.util.ArrayList;

public class Work1
{
    public static void main(String[] args)
    {
        Car c1 = new Car("宝马", 4000);
        Car c2 = new Car("宾利", 3000);

        ArrayList ast = new ArrayList();

        //add
        ast.add(c1);
        ast.add(c2);

        //remove
        ast.remove(c1);

        //contains
        System.out.println("c1是否存在： " + ast.contains(c1));

        //size
        System.out.println("ast.size() = " + ast.size());

        //isEmpty
        System.out.println("ast.isEmpty() = " + ast.isEmpty());

        //clear
        ast.clear();



    }
}


class Car
{
    private String name;
    private int price;

    public Car(String name, int price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }
}
