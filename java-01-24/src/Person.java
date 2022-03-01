public class Person
{
    private String name;
    private int age;

    Person(String name, int age)
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

    public static void main(String[] args)
    {
        Person p = new Person("宁", 4000);
        System.out.println("姓名： " + p.getName() + "  年龄： " + p.getAge());

    }


}
