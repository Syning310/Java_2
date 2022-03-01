package interface_0;



interface A
{
    int x = 0;   //public static final
}
class B
{
    int x = 1;    //普通属性
}

class C extends B implements A
{
    public void pX()
    {
        //System.out.println(x);
        System.out.println("A.x = " + A.x);
        System.out.println("super.x = " + super.x);
    }
}

public class Test02
{
    public static void main(String[] args)
    {
        new C().pX();
    }
}


