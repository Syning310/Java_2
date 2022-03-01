package equals_;

public class test01
{
    public static void main(String[] args)
    {
        Person p1 = new Person("宁", 20, '男');
        Person p2 = new Person("宁", 20, '男');
        Person p3 = new Person("颜", 18, '女');

        System.out.println("p1 == p2  : " + (p1 == p2));
        System.out.println("p1.equals(p2) : " + p1.equals(p2));

        System.out.println("p1.equals(p3) : " + p1.equals(p3));

        


    }
}
