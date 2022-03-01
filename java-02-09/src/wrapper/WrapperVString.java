package wrapper;

public class WrapperVString
{
    public static void main(String[] args)
    {

        //包装类 转 String
        Integer i = 100;

        //方法一
        String str = i + "";  //新对象，"100"   但不会改变i

        //方法二
        String str2 = i.toString();

        //方法三
        String str3 = String.valueOf(i);



        //String 转 包装类
        String s = "123";

        //方法一
        Integer i2 = Integer.parseInt(s);

        //方法二
        Integer i3 = new Integer(s);

        System.out.println(Integer.MAX_VALUE);

    }
}
