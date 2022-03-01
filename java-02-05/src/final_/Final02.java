package final_;

public class Final02
{
    public static final double RATE = 0.08;


    public static void main(String[] args)
    {
        System.out.println(Final02.RATE);
        //Final02.RATE = 0.09;   //无法修改final修饰的属性

        final int MAX_A = 100;
        System.out.println("MAX_A = " + MAX_A);
        //MAX_A = 200;  //final修饰的局部变量无法被修改


    }

}
