package generic;


import java.util.ArrayList;
import java.util.List;

public class GenericExtends
{
    public static void main(String[] args)
    {
        List<Object> lst1 = new ArrayList<>();
        List<String> lst2 = new ArrayList<>();
        List<AA> lst3 = new ArrayList<>();
        List<BB> lst4 = new ArrayList<>();
        List<CC> lst5 = new ArrayList<>();

        p1(lst1);p1(lst2);p1(lst3);p1(lst4);p1(lst5);

        //p2(lst1);
        //p2(lst2);
        p2(lst3);
        p2(lst4);
        p2(lst5);

        p3(lst1);
        //p3(lst2);
        p3(lst3);
        //p3(lst4);
        //p3(lst5);


    }

    //可以是任意泛型
    public static void p1(List<?> c)
    {
        for (Object obj : c)
        {
            System.out.println(obj);
        }
    }

    //规定泛型的上限：可以接收 AA 或 AA的子类
    public static void p2(List<? extends AA> c)
    {
        for (Object obj : c)
        {
            System.out.println(obj);
        }
    }

    //规定泛型的下线：可以接收 AA 或 AA的父类(间接父类也可以)
    public static void p3(List<? super AA> c)
    {
        for (Object obj : c)
        {
            System.out.println(obj);
        }
    }

}

class AA
{

}

class BB extends AA
{

}

class CC extends BB
{

}
