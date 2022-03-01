package generic;

import java.util.ArrayList;

public class Generic0
{
    public static void main(String[] args)
    {

        //使用泛型
        ArrayList<Dog0> at = new ArrayList<>();


        at.add(new Dog0("小黄", 20));
        at.add(new Dog0("小白", 18));
        at.add(new Dog0("小紫", 12));

        //加入不小心加入了一只猫，此时添加的类型，不是Dog0或者Dog0的子类，就会出错
        //at.add(new Cat0("小绿", 10));

        //而在遍历时，就可以直接取出Dog0类型
        for (Dog0 d : at)
        {
            System.out.println(d.getName() + "  " + d.getAge());
        }



    }

}
