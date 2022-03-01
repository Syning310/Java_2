package local_innerclass;


public class LocalInnerClass00  //6、其他外部类不能访问Person的局部内部类
{
    public static void main(String[] args)
    {
        Person p = new Person();
        p.moveLegs();

        System.out.println("p的hashCode() = " + p.hashCode());


    }

}


class Person
{
    private String name = "宁";
    private int age = 20;

    public void moveLegs()
    {

        //3、作用域：仅仅在这个代码块中
        class Legs  //2、不能添加访问修饰符，因为它的地位是一个局部变量，但可以使用final，不允许继承
        {
            private String name = "筱筱";  //内部类的姓名
            private int toes = 5;    //脚趾头

            public void introduceMaster()
            {
                System.out.println("我的姓名是: " + this.name);
                //1、可以直接访问外部类的所有成员，包括私有权限
                System.out.println("主人姓名: " + Person.this.name + "  主人年龄: " + Person.this.age);
                //4、访问外部成员可以直接访问
                // 7、如果局部内部类和外部类的成员重名时，默认遵循就近原则，如果想访问外部类的成员，用 (外部类名.this.成员)

                //Person.this类似于this指针，谁调用这个函数，他就指向谁
                System.out.println("Person.this.hashCode() = " + Person.this.hashCode());

            }

            public int getToes()
            {
                return toes;
            }
        }

        //5、外部类要访问，需要创建对象，并且必须在作用域内
        Legs le = new Legs();
        le.introduceMaster();
        System.out.println("我有 " + le.getToes() * 2 + " 个脚趾头");
        System.out.println("le.hashCode() = " + le.hashCode());

    }



}

