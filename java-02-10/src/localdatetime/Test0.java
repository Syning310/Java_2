package localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Test0
{
    public static void main(String[] args)
    {
        //1、第三代日期类


        LocalDateTime ldt = LocalDateTime.now();  //返回表示当前日期时间的对象   年月日，时分秒

        System.out.println("ldt = " + ldt);

        System.out.println(ldt.getYear() + "年 " + ldt.getMonth() + "月 " + ldt.getDayOfMonth() + "日 " +
                            ldt.getHour() + "时 " + ldt.getMinute() + "分 " + ldt.getSecond() + "秒");

        //LocalDate ld = LocalDate.now();   //获取年月日
        //LocalTime lt = LocalTime.now();   //获取时分秒



        //2、使用DateTimeFormatter 对象来进行格式化定制
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy年MM月dd日 HH点mm分ss秒");
        String strDate = dtf.format(ldt);

        System.out.println("格式化后的ldt = " + strDate);







    }
}
