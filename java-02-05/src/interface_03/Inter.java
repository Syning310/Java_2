package interface_03;

import abstract_1.A;

public interface Inter
{
    int a = 30;
}
class B implements Inter { }
class M
{
    public static void main(String[] args)
    {
        B b = new B();
        System.out.println("b.a = " + b.a);
        System.out.println("Inter.a = " + Inter.a);
        System.out.println("B.a = " + B.a);
    }
}


