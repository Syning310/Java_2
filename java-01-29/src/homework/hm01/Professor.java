package homework.hm01;

public class Professor extends Teacher
{
    public Professor() {  }

    public Professor(String name, int age, String post, double salary)
    {
        super(name, age, post, salary);

    }

    public String introduce()
    {
        return "姓名: " + this.getName() + "  年龄: " + this.getAge() + "  岗位: " + this.getPost() + "  工资: " + (this.getSalary() * 1.3);
    }


}
