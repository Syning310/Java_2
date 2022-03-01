package system_;

public class Tast01
{
    public static void main(String[] args)
    {
        long start = 0;
        long end = 0;

        start = System.currentTimeMillis();
        StringBuffer s2 = new StringBuffer();
        for (int i = 0; i < 60000; ++i)
        {
            s2.append("h");
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer用时： " + (end - start) + "毫秒数");


        start = System.currentTimeMillis();
        String s1 = "";
        for (int i = 0; i < 60000; ++i)
        {
            s1 += "h";
        }
        end = System.currentTimeMillis();
        System.out.println("String用时： " + (end - start) + " 毫秒数");



    }

    public int add(final int v1, final int v2)
    {

        return v1 - v2;
    }


}
