package Zexercise;

class Outer00
{
    public Outer00()
    {
        Inner00 s1 = new Inner00();
        s1.a = 10;
        Inner00 s2 = new Inner00();
        System.out.println("s2.a = " + s2.a);
    }

    class Inner00
    {
        public int a = 5;
    }
}

public class Test00
{
    public static void main(String[] args)
    {
        Outer00 t = new Outer00();
        Outer00.Inner00 r = t.new Inner00();
        System.out.println("r.a = " + r.a);
    }
}
