package polymorphic;

public class Bone extends Food
{
    private String name;

    public Bone()
    {
        this.name = null;
    }

    public Bone(String name)
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

