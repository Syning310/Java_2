package exception_;

public class NumberFormatException_
{
    public static void main(String[] args)
    {

        String name = "宁";

        try
        {
            int n = Integer.parseInt(name);
        }
        catch (java.lang.NumberFormatException n)
        {
            System.out.println(n.getMessage());
        }




    }
}
