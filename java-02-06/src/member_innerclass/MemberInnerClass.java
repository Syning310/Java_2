package member_innerclass;

public class MemberInnerClass
{
    public static void main(String[] args)
    {
          Person p = new Person();
          p.test();

        //外部其他类，使用成员内部类
        //第一种
        Person.Hand ph = p.new Hand();
        ph.say();

        //第二种
        Person.Hand ph2 = p.getHandInstance();
        ph2.say();

        //第三种
        Person.Hand ph3 = new Person().new Hand();

    }
}


class Person
{
    private String name = "宁";
    private int age = 20;

    //成员内部类,地位是成员，所以可以使用访问修饰符来修饰
    public class Hand
    {
        int num = 2;
        public void say()
        {
            System.out.println("姓名: " + Person.this.name + "   年龄: " + Person.this.age + "   有 " + this.num + " 只手臂");
        }
    }

    //外部类想要使用成员内部类 Hand  必须创建对象实例
    public void test()
    {
        Hand h = new Hand();
        h.say();
    }

    //返回一个 Hand 内部成员的对象
    public Hand getHandInstance()
    {
        return this.new Hand();
    }

}
