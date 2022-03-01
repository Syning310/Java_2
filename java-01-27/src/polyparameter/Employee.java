package polyparameter;

public class Employee
{
    private String name;
    private int monSalary;

    public Employee()
    {
        this.name = null;
        this.monSalary = 0;
    }
    public Employee(String name, int monSalary)
    {
        this.setName(name);
        this.setMonSalary(monSalary);
    }


    public int getAnnual()
    {
        return this.monSalary * 12;
    }


    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }

    public void setMonSalary(int monSalary)
    {
        this.monSalary = monSalary;
    }
    public int getMonSalary()
    {
        return this.monSalary;
    }

}
