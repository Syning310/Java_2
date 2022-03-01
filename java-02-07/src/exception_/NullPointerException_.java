package exception_;

public class NullPointerException_
{
    public static void main(String[] args)
    {

        String name = null;

        try
        {
            System.out.println(name.length());
        }
        catch (java.lang.NullPointerException p)
        {
            System.out.println(p.getMessage());
        }

    }

}
