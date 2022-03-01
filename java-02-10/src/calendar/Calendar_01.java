package calendar;

import java.util.Calendar;

public class Calendar_01
{
    public static void main(String[] args)
    {

        Calendar cd = Calendar.getInstance();

        System.out.println("cd = " + cd);

        //获取月份要 +1  因为对象的字段的月份是从0开始的
        System.out.println("年：" + cd.get(Calendar.YEAR) +
                            " 月：" + (cd.get(Calendar.MONTH) + 1) +
                            " 日：" + cd.get(Calendar.DAY_OF_MONTH) +
                            " 小时：" + cd.get(Calendar.HOUR_OF_DAY) +
                            " 分钟：" + cd.get(Calendar.MINUTE) +
                            " 秒：" + cd.get(Calendar.SECOND));


    }
}
