package extend_detail;

public class Base   //父类
{
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public Base()
    {
        System.out.println("Base的构造器...");
    }

    public void test01()
    {
        System.out.println("public test01...");
    }

    protected void test02()
    {
        System.out.println("protected test02...");
    }

    void test03()
    {
        System.out.println("default test03...");
    }

    private void test04()
    {
        System.out.println("private test04...");
    }




    protected int getN4()
    {
        return this.n4;
    }






}
