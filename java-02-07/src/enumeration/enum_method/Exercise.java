package enumeration.enum_method;

public class Exercise
{
    public static void main(String[] args)
    {
        Week[] weeks = Week.values();

        System.out.println("所有星期的日期如下");
        for (Week k : weeks)
        {
            System.out.println(k);
        }

    }

}

enum Week
{
    MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THURSDAY("星期四"),
    FRIDAY("星期五"), SATURDAY("星期六"), SUNDAY("星期日");

    private String date;
    Week(String date)
    {
        this.date = date;
    }

    public String toString()
    {
        return this.date;
    }
}
