package wrapper;

public class CommonMethod
{
    public static void main(String[] args)
    {

        System.out.println(Character.toUpperCase('A'));
        System.out.println(Character.toUpperCase('a'));

        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);  //f

        Integer m = 1;
        Integer n = 1;               //    源码是调用Integer.valueOf(1)
        System.out.println(m == n);  //t   这里主要看范围，如果是-128 ~ 127就是直接返回，所以是同一个对象

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);  //f


    }
}
