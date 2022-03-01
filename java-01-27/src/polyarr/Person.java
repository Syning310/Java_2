package polyarr;

public class Person
{
    private String name;
    private int age;

    public Person()
    {
        this.name = null;
        this.age = 0;
    }
    public Person(String name, int age)
    {
        this.setName(name);
        this.setAge(age);
    }

    public String say()
    {
        return "name: " + this.getName() + "  age: " + getAge();
    }


    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
    public int getAge()
    {
        return this.age;
    }

}
