package custom_exception;

public class CustomException_
{
    public static void main(String[] args)
    {

        int age = 180;

        try
        {
            if (!(age >= 18 && age <= 120))
            {
                throw new AgeException("年龄需要在 18 ~ 120 之间");
            }

            System.out.println("你的年龄范围正确，为： " + age);
        }
        catch (AgeException a)
        {
            System.out.println(a.getMessage());
        }




    }

}

class  AgeException extends RuntimeException
{
    public AgeException(String message)
    {
        super(message);
    }

}





