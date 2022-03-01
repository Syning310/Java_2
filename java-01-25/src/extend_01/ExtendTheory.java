package extend_01;


import java.util.Scanner;

class GrandPa
{
    public String name = "爷爷";
    public String hobby = "旅游";
}
class Father extends GrandPa
{
    public String name = "爸爸";
    int age = 30;
    public int getAge()
    {
        return this.age;
    }
}
class Son extends Father
{
    public String name = "儿子";
    private int age = 10;
}


public class ExtendTheory
{
    public static void main(String[] args)
    {
        Son s1 = new Son();

        System.out.println("s1.name = " + s1.name);

        System.out.println("s1.getAge() = " + s1.getAge());

        System.out.println("s1.hobby = " + s1.hobby);
    }

}
