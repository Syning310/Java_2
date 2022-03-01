package stringbuffer_;

public class Test1
{
    public static void main(String[] args)
    {
        StringBuffer s = new StringBuffer("hello");

        //append
        s.append(',');    //hello,
        s.append("java"); //hello,java
        s.append(",c").append(",c++").append(",php");  //hello,java,c,c++,php
        System.out.println(s);


    }
}
