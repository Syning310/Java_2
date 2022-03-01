package localdatetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test1
{
    public static void main(String[] args)
    {

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy年MM月dd日 HH点mm分ss秒");


        //使用plus和mins方法可以对当前时间进行加减

        //看看980天后，是什么时候
        LocalDateTime newT = ldt.plusDays(980);

        String time = dtf.format(newT);

        System.out.println("980天后是： " + time);

        //看看900000分钟前，是什么时候
        LocalDateTime oldT = ldt.minusMinutes(900000);

        time = dtf.format(oldT);
        System.out.println("九十万分钟之前是: " + oldT);


    }
}
