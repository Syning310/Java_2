package polymorphic;

public class Animal
{
    private String name;

    public Animal()
    {
        this.name = null;
    }
    public Animal(String name)
    {
        this.setName(name);
    }


    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }



}
