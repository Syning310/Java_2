package printstream_;

import java.io.PrintStream;

public class PrStream
{
    public static void main(String[] args)
    {
        PrintStream o = System.out;

        //在默认情况下，PrintStream输出数据的位置是，标准输出，即显示器
        o.print("宁");

        o.close();


    }
}
