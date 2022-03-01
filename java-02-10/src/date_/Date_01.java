package date_;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_01
{
    public static void main(String[] args) throws java.text.ParseException
    {
        Date d = new Date();    //获取当前系统时间

        System.out.println("当前时间为： " + d);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年 MM月 dd日 hh:mm:ss E");
        String timeNow = sdf.format(new Date());

        System.out.println("当前时间为： " + timeNow);


        String s = "2025年 01月 01日 10:22:30 星期一";

        Date par = sdf.parse(s);
        System.out.println("转换的时间为： " + sdf.format(par));



    }
}
