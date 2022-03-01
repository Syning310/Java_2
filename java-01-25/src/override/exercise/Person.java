package override.exercise;

public class Person
{
    private String name;
    private int age;

    public Person()
    {
        String name = null;
        int age = 0;
    }

    public Person(String name, int age)
    {
        this.setName(name);
        this.setAge(age);
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


    public String say()
    {
        return "姓名： " + this.getName() + "  年龄： " + this.getAge();
    }


}
