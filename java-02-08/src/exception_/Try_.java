package exception_;

public class Try_
{
    public static void main(String[] args)
    {

        try
        {
            String str = "宁";
            int a = Integer.parseInt(str);
            System.out.println("a = " + a);
        }
        catch (NumberFormatException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            System.out.println("finally代码块...");
        }


        System.out.println("程序继续执行...");

    }

}
