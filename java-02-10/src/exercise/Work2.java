package exercise;

import java.util.Arrays;

public class Work2
{
    public static void main(String[] args)
    {
        Test01.cal();

    }
}

//将字符串中指定的部分进行反转
class Test01
{
    public static void cal()
    {
        String str = "abcdef";    //反转成aedcbf
        //abcdefg    afedcbg


        String str2 = "qwertyuiop[";
        try
        {
            String n = reverse(str2, 0, str2.length() - 1);
            System.out.println(n);
        }
        catch(RuntimeException r)
        {
            System.out.println(r.getMessage());
        }



    }
    public static String reverse(String str, int start, int end)
    {
        //对传入的参数做一个验证,写出正确的情况，然后取反
        if (!(str != null && start >= 0 && end > start && end < str.length()))
        {
            throw new RuntimeException("参数不正确");
        }


        char[] c = str.toCharArray();

        char tmp = ' ';
        int s = start;
        int e = end;

        while (s < e)
        {
            tmp = c[s];
            c[s] = c[e];
            c[e] = tmp;
            ++s;
            --e;
        }

        return new String(c);


        //System.out.println(c);


    }

}
