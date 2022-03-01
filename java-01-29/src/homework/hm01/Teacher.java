package homework.hm01;

public class Teacher
{
    private String name;
    private int age;
    private String post;
    private double salary;

    public Teacher() {  }

    public Teacher(String name, int age, String post, double salary)
    {
        this.setName(name);
        this.setAge(age);
        this.setPost(post);
        this.setSalary(salary);
    }

    public String introduce()
    {
        return "姓名: " + this.getName() + "  年龄: " + this.getAge() + "  岗位: " + this.getPost() + "  工资: " + this.getSalary();
    }



    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getPost()
    {
        return post;
    }

    public void setPost(String post)
    {
        this.post = post;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }


}
