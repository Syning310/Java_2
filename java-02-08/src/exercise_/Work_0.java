package exercise_;

import java.util.Scanner;

public class Work_0
{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        boolean loop = true;
        String str = "";
        Integer num = null;

        repeat:
        while (loop)
        {
            System.out.println("请输入整数");
            str = sc.next();
            try
            {
                num = Integer.parseInt(str);
                loop = false;
            }
            catch (NumberFormatException n)
            {
                continue repeat;
            }
        }
        System.out.println("你输入的整数是： " + num);


    }
}
