package stringbuffer_;

public class Test2
{
    public static void main(String[] args)
    {

        //金额添加 ,
        String price = "1231232123564.59";

        //找到小数点的索引，然后在索引的前3位，插入 , 即可

        StringBuffer sb = new StringBuffer(price);

        for (int index = sb.lastIndexOf(".") - 3; index > 0; index -= 3)
        {
            sb = sb.insert(index, ",");
        }

        System.out.println(sb);


    }
}
