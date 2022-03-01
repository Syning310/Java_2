package poly_detail;

public class Dog extends Animal
{

    public int age = 13;

    public Dog()
    {
        super();
    }
    public Dog(String name)
    {
        super(name);
    }

    public void run()
    {
        System.out.println("小狗： " + this.name + " 在跑...");
    }

    public void eat()
    {
        System.out.println("小狗" + this.name + " 在吃狗粮...");
    }

    public int getAge()
    {
        return this.age;
    }


}
