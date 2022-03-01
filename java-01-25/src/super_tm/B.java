package super_tm;

public class B extends A
{


    public void cal()
    {
        //访问父类的属性，但不能访问private属性   super.属性
        System.out.println("super.n1 = " + super.n1 + "  super.n2 = " + super.n2 + "  super.n3 = " + super.n3);
        System.out.println("this.n1 = " + this.n1 + "  this.n2 = " + this.n2 + "  this.n3 = " + this.n3);

        //访问父类的方法，但不能访问private方法   super.方法
        System.out.print("super.test01() = ");
        super.test01();
        System.out.print("super.test02() = ");
        super.test02();
        System.out.print("super.test03() = ");
        super.test03();

        System.out.print("this.test01() = ");
        this.test01();
        System.out.print("this.test02() = ");
        this.test02();
        System.out.print("this.test03() = ");
        this.test03();



    }
}
