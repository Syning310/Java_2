package abstract_;

abstract class Animal
{
    public String name;
    public int age;
    public Animal() { }
    public Animal(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    //将该方法设计为抽象方法
    public abstract void eat();

}

public class Abstract00
{
    public static void main(String[] args)
    {


    }

}


