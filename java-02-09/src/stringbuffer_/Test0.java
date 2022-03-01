package stringbuffer_;


public class Test0
{
    public static void main(String[] args)
    {

        StringBuffer str = new StringBuffer();

        //通过构造器指定char的大小
        StringBuffer str2 = new StringBuffer(200);

        StringBuffer sb = new StringBuffer("宁");

        //append返回StringBuffer对象
        sb.append("颜");

        System.out.println(sb);


        String s1 = sb.toString();
        System.out.println(s1);

        s1 = new String(sb);
        System.out.println(s1);



    }
}
