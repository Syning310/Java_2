package polyarr;

public class Teacher extends Person
{
    private double salary;


    public Teacher()
    {
        super();
        this.salary = 0.0;
    }
    public Teacher(String name, int age, double salary)
    {
        super(name, age);
        this.setSalary(salary);
    }

    public String say()
    {
        return super.say() + "  salary: " + this.getSalary();
    }

    public String teach()
    {
        return this.getName() + " 正在授课";
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }
    public double getSalary()
    {
        return this.salary;
    }

}
