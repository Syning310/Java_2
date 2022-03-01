package exercise;

public class Work4
{
    public static void main(String[] args)
    {
        //遍历字符串，如果char在 0-9 就是一个数字
        //如果char在 a-z 就是小写字母
        //如果char在 A-Z 就是大写字母
        //用三个变量，统计结果

        String str = "abc123456789ABCDE";

        int numCount = 0;
        int bigCount = 0;
        int smallCount = 0;

        char[] c = str.toCharArray();

        for (int i = 0; i < c.length; ++i)
        {
            //如果字符小于0
            if (c[i] >= '0' && c[i] <= '9')
            {
                ++numCount;
            }
            else if (c[i] >= 'a' && c[i] <= 'z')
            {
                ++smallCount;
            }
            else if (c[i] >= 'A' && c[i] <= 'Z')
            {
                ++bigCount;
            }
        }

        System.out.println("str字符串中有： " + numCount + " 个数字，有 " + smallCount + " 个小写字母， 有 " + bigCount + " 个大写字母");



    }
}
