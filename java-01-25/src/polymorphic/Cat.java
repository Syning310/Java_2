package polymorphic;

public class Cat extends Animal
{
    private String name;

    public Cat()
    {
        this.name = null;
    }
    public Cat(String name)
    {
        this.setName(name);
    }

//    public void setName(String name)
//    {
//        this.name = name;
//    }
//    public String getName()
//    {
//        return this.name;
//    }

}
