package abstract_;

public abstract class Employee
{
    private String name;
    private int id;
    private int salary;


    public abstract void work();


    public Employee() {}

    public Employee(String name, int id, int salary)
    {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getSalary()
    {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }
}



class Manager extends Employee
{
    private int bonus;


    public void work()
    {
        System.out.println("管理-姓名: " + this.getName() + "   id: " + this.getId() +
                            "   工资: " + (this.getSalary() + this.getBonus()));
    }


    public Manager() {}

    public Manager(String name, int id, int salary, int bonus)
    {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public int getBonus()
    {
        return bonus;
    }

    public void setBonus(int bonus)
    {
        this.bonus = bonus;
    }
}

class CommonEmployee extends Employee
{
    public void work()
    {
        System.out.println("普通员工-姓名: " + this.getName() + "   id: " + this.getId() +
                            "   工资: " + this.getSalary());
    }

    public CommonEmployee() {}

    public CommonEmployee(String name, int id, int salary)
    {
        super(name, id, salary);
    }
}


