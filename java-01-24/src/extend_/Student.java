package extend_;

public class Student
{
    protected String name;
    protected int age;
    protected double score;

    public Student()
    {
        this.name = "";
        this.age = 0;
        this.score = 0.0;
    }

    public Student(String name, int age, double score)
    {
        this.setName(name);
        this.setAge(age);
        this.setScore(score);
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

    public void setScore(double score)
    {
        this.score = score;
    }
    public double getScore()
    {
        return this.score;
    }


    public void testing()
    {
        System.out.println(this.getName() + "  正在考试！！！");
    }


    public void showInfo()
    {
        System.out.println("姓名: " + this.getName() + "  年龄： " + this.getAge() + " 成绩：" + this.getScore());

    }
}
