package polyparameter;

public class PloyParameter
{

    public static void main(String[] args)
    {
        Manger m1 = new Manger("尘", 10, 80);
        System.out.println(showEmpAnnual(m1));  //200
        testWork(m1);   //子类特有的manage

        OrdinaryEmployee oe1 = new OrdinaryEmployee("纤", 20);
        System.out.println(showEmpAnnual(oe1));  //240
        testWork(oe1);  //子类特有的work

        Employee e1 = new Employee("雪", 5);
        System.out.println(showEmpAnnual(e1));  //60
        testWork(e1);   //无

    }



    //测试类中要求添加一个方法  showEmpAnnual(Employee ele)  实现获取任何员工对象的年工资
    public static int showEmpAnnual(Employee ele)
    {
        return ele.getAnnual();  //都是从运行类型中开始查找是否有getAnnual，如果没有再向上查找

//        if (ele instanceof Manger)
//        {
//            return ((Manger)ele).getAnnual();
//        }
//        else if (ele instanceof OrdinaryEmployee)
//        {
//            return ((OrdinaryEmployee)ele).getAnnual();
//        }
//        else    //如果运行类型不是Employee的子类型，那么只能是Employee
//        {
//            System.out.println("员工");
//            return ele.getAnnual();
//        }
    }

    //测试类中添加一个方法，  testWork(Employee ele)   如果是普通员工，或者经理，则调用子类中特有的work方法或manage方法
    public static void testWork(Employee ele)
    {
        if (ele instanceof Manger)
        {
            ((Manger)ele).manage();  //调用子类特有的manage
        }
        else if (ele instanceof OrdinaryEmployee)
        {
            ((OrdinaryEmployee)ele).work();  //调用子类特有的work
        }
        else
        {
            System.out.println("无");
        }

        //Employee没有work方法


    }


}
