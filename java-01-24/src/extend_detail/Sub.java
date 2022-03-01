package extend_detail;

public class Sub extends Base
{
    public Sub()
    {
        System.out.println("Sub的构造器...");
    }


    public void cal()
    {
        System.out.println("n1 = " + n1);  //public     可以在子类中直接访问
        System.out.println("n2 = " + n2);  //protected  可以在子类中直接访问
        System.out.println("n3 = " + n3);  //default    在子类中不能访问，但是在同一个包下可以访问
        //System.out.println("n4 = " + n4);  //n4在父类中是private所以不能访问
        System.out.println("n4 = " + this.getN4());  //通过父类中的 protected 修饰的 getN4 访问


        this.test01();  //public
        this.test02();  //protected
        this.test03();  //default
        //this.test04();  //private


    }

    public static void main(String[] args)
    {
        Sub s1 = new Sub();
        s1.cal();

    }


}
