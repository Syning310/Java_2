package exception_;

public class exception_0
{
    public static void main(String[] args)
    {

        int a = 10;
        int b = 0;
        int ret = 0;

        try
        {
            ret = a / b;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


        System.out.println("程序继续运行...");

    }
}
