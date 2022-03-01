package exception_;

public class ArrayIndexOutBoundsException_
{
    public static void main(String[] args)
    {

        int[] array = {1, 2, 3, 4, 5};

        try
        {
            System.out.println(array[5]);
        }
        catch (java.lang.ArrayIndexOutOfBoundsException a)
        {
            System.out.println(a.getMessage());
        }


    }


}
