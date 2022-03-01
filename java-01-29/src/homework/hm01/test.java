package homework.hm01;

public class test
{
    public static void main(String[] args)
    {
        Teacher t = new Teacher("宁", 28, "教师", 4000);
        System.out.println(t.introduce());

        t = new Professor("颜", 20, "教授", 4000);
        System.out.println(t.introduce());



    }
}
