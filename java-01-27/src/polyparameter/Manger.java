package polyparameter;

public class Manger extends Employee
{
    private int bonus;

    public Manger()
    {
        super();
        this.bonus = 0;
    }
    public Manger(String name, int monSalary, int bonus)
    {
        super(name, monSalary);
        this.setBonus(bonus);
    }

    //管理方法
    public void manage()
    {
        System.out.println("经理的 manage 方法...");
    }

    //重写父类的getAnnual    年工资 + 奖金
    public int getAnnual()
    {
        System.out.println("经理的年工资计算");
        return super.getAnnual() + this.getBonus();
    }



    public void setBonus(int bonus)
    {
        this.bonus = bonus;
    }
    public int getBonus()
    {
        return this.bonus;
    }
}
