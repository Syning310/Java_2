package polymorphic;

public class Master
{
    private String name;

    public Master()
    {
        this.name = null;
    }

    public Master(String name)
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

    public String feed(Animal a, Food f)
    {
        return "主人： " + this.getName() + "  给宠物： " + a.getName() +  "  喂： " + f.getName();
    }

}
