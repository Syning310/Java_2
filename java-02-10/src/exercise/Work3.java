package exercise;

import java.util.Scanner;

public class Work3
{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        //要求，姓名2-4个字符，密码6位数并全数字，邮箱有 @. 并且 @ 在 . 的前面
        try
        {
            addUser();
            System.out.println("注册成功");
        }
        catch(RuntimeException r)
        {
            System.out.println(r.getMessage());
        }

    }

    public static void addUser()
    {
        String name = enterName();
        if (!(name.length() >= 2 && name.length() <= 4))
        {
            throw new RuntimeException("name 应大于等于2，或小于等于4");
        }

        String secret = enterSecret();
        if (!(secret.length() == 6 && isDigital(secret)))
        {
            throw new RuntimeException("密码的长度应为6，要求全是数字");
        }

        String mail = enterMail();
        int i = mail.indexOf('@');
        int d = mail.indexOf('.');
        //如果 i 大于 -1 也就是说 字符串中没有@

        if (!(i > -1 && d > i))
        {
            throw new RuntimeException("邮箱中应包含@和. 并且@在.前面");
        }

    }


    //单独写一个方法，判断 密码是否全部都是数字
    public static boolean isDigital(String str)
    {
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; ++i)
        {
            if (c[i] < '0' || c[i] > '9')
            {
                return false;
            }
        }
        return true;
    }


    public static String enterName()
    {
        System.out.print("请输入用户名>: ");

        return sc.next();
    }
    public static String enterSecret()
    {
        System.out.print("请输入密码>: ");
        return sc.next();
    }
    public static String enterMail()
    {
        System.out.print("请输入邮箱>: ");
        return sc.next();
    }

}

