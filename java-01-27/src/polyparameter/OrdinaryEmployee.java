package polyparameter;

public class OrdinaryEmployee extends Employee
{
    public OrdinaryEmployee()
    {
        super();
    }
    public OrdinaryEmployee(String name, int monSalary)
    {
        super(name, monSalary);
    }

    public void work()
    {
        System.out.println("普通员工的 work 方法...");
    }

    public int getAnnual()
    {
        System.out.println("普通员工的年工资计算");
        return super.getAnnual();
    }

}
