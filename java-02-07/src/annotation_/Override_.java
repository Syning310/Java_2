package annotation_;




public class Override_
{

    public static void main(String[] args)
    {
        @SuppressWarnings({"all"})
        Father f = new Father();
        f.hello();

    }
}


@SuppressWarnings({"all"})
@Deprecated
class Father
{


    public void fly()
    {
        System.out.println("Father fly...");
    }


    public void hello()
    {
        System.out.println("hello world");
    }

}

@SuppressWarnings({"all"})
class Son extends Father
{
    @Override

    public void fly()
    {
        System.out.println("Son fly...");
    }
}
