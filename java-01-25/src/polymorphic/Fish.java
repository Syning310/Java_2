package polymorphic;

public class Fish extends Food
{
    private String name;

    public Fish()
    {
        this.name = null;
    }
    public Fish(String name)
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
