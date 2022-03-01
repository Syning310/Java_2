package class_object;

public class test00
{
    public static void main(String[] args)
    {
        String str1 = new String("宁");
        String str2 = new String("宁");
        String str3 = str1;

        System.out.println(str1 == str2);  //比较的是地址
        System.out.println(str1.equals(str2));  //比较的是对象的值
        System.out.println(str3 == str1);  //比较的是地址

        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        System.out.println(i1.equals(i2));



    }
}
