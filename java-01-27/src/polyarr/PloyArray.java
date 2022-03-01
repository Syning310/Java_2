package polyarr;

public class PloyArray
{

    public static void main(String[] args)
    {
        Person pArr[] = {new Person("宁", 4500), new Student("雪", 4000, 100),
                         new Student("尘", 2000, 70), new Teacher("颜", 4500, 80), new Teacher("一", 5000, 10)};

        for (Person p : pArr)
        {
            System.out.println(p.say());
            //调用子类特有的方法

            //先判断运行类型是否是Student或者是Student的子类
            if (p instanceof Student)
            {
                System.out.println(((Student)p).study());
            }
            else if (p instanceof Teacher)
            {
                System.out.println(((Teacher)p).teach());
            }


        }


    }


}
