package polymorphic;

public class Food
{
    private String name;

    public Food()
    {
        this.name = null;
    }
    public Food(String name)
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
