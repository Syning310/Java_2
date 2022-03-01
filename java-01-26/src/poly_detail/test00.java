package poly_detail;

public class test00
{
    public static void main(String[] args)
    {
        Animal ani = new Cat("宁");

        //只能调用编译类型中拥有的方法
        ani.metabolism();
        ani.breather();

        //把ani的编译类型  转换成与运行类型一样
        Cat ct = (Cat)ani;
        //转换成功后，编译类型和运行类型就一样了
        ct.metabolism();
        ct.breather();
        ct.run();
        ct.eat();

        //如果用Dog编译类型 去指向Cat运行类型，就会出现异常
        //Dog dg = (Dog)ani;

        //而编译类型和运行类型一致时，可以把编译类型转换成父类
        Animal aq = (Animal)ct;
        aq.breather();
        aq.metabolism();

        //创建动物对象
        Animal ip = new Animal("月");
        //编译类型 猫，不能指向运行类型 动物        猫是动物，但动物不是猫
        //Cat c = (Cat)ip;



    }
}
