package poly_detail;

public class Cat extends Animal
{

    public int age = 10;

    public Cat()
    {
        super();
    }
    public Cat(String name)
    {
        super(name);
    }

    public void run()
    {
        System.out.println("小猫： " + this.name + " 在爬...");
    }

    public void eat()
    {
        System.out.println("小猫： " + this.name + " 在吃猫粮...");
    }

}
