package poly_detail;

public class Animal
{
    public String name;

    public int age = 100;

    public Animal()
    {
        this.name = null;
    }
    public Animal(String name)
    {
        this.name = name;
    }

    public void metabolism()
    {
        System.out.println(this.name + " 在新陈代谢....");
    }

    public void breather()
    {
        System.out.println(this.name + " 在呼吸....");
    }

    public int getAge()
    {
        return this.age;
    }


}
