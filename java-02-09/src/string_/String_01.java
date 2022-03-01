package string_;

public class String_01
{

    public final int[] arr;


    public String_01()
    {

        this.arr = new int[3];
    }

    public static void main(String[] args)
    {


        String s = "syning";
        String str = new String("syning");
        System.out.println(str.equals(s));
        System.out.println(s == str);

        System.out.println("syning" == s.intern());

        String_01 arr = new String_01();

        arr.arr[0] = 100;
        arr.arr[1] = 200;
        arr.arr[2] = 300;

        System.out.println(arr.hashCode());

        final char[] c = {'a', 'b', 'c'};

        System.out.println(c);

        c[0] = 'q';

        System.out.println(c);

        System.out.println("==========================");
        String p1 = "hello" + "abc";
        String p2 = "helloabc";
        System.out.println(p1 == p2);

        String q1 = "hello";
        String q2 = "abc";
        String q3 = q1 + q2;
        System.out.println(p2 == q3);


    }

}
