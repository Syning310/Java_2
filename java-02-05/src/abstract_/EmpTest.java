package abstract_;

public class EmpTest
{
    public static void main(String[] args)
    {
        Employee el = new Manager("宁", 001, 200, 10);

        el.work();

        el = new CommonEmployee("月", 002, 90);
        el.work();
    }
}
