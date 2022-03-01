package homework.hm00;

public class test00
{
    public static void main(String[] args)
    {
        Person p1 = new Person("宁", 21, "大冥山");
        Person p2 = new Person("颜", 18, "梧桐");
        Person p3 = new Person("月", 100, "永夜");
        Person p4 = new Person("尘", 11, "不夜");
        Person p5 = new Person("青", 70, "天");
        Person p6 = new Person("雪", 6, "长安");
        Person p7 = new Person("瑶", 2000, "鬼");

        Person[] pArr = {p1, p2, p3, p4, p5, p6, p7};

        System.out.println("排序之前： ");
        for (Person p : pArr)
        {
            System.out.println("name: " + p.getName() + "  age: " + p.getAge() + "  address: " + p.getAddress());
        }

        bbp(pArr);

        System.out.println("=================================");
        System.out.println("排序之后： ");
        for (Person p : pArr)
        {
            System.out.println("name: " + p.getName() + "  age: " + p.getAge() + "  address: " + p.getAddress());
        }

    }


    public static void bbp(Person[] p)
    {
        for (int i = 0; i < p.length - 1; ++i)
        {
            for (int j = 0; j < p.length - i - 1; ++j)
            {
                if (p[j].getAge() < p[j + 1].getAge())
                {
                    Person tmp = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = tmp;
                }
            }
        }
    }

}
