package enumeration.enum_method;

public class Test0
{
    public static void main(String[] args)
    {
        //输出枚举对象的名字
        System.out.println(Season.SPRING);  //toString方法中 return name()
        System.out.println(Season.SPRING.name());

        System.out.println(Season.WINTER.ordinal());

        Season[] arrSea = Season.values();
        for (Season s : arrSea)
        {
            System.out.print(s);
            System.out.print("  ");
        }
        System.out.println();

        System.out.println(Season.SPRING.compareTo(Season.WINTER));

    }
}

enum Season
{
    SPRING("春天", "温暖"), SUMMER("夏天", "炎热"), AUTUMN("秋天", "凉爽"), WINTER("冬天", "寒冷");

    private String name;
    private String desc;
    Season(String name, String desc)
    {
        this.name = name;
        this.desc = desc;
    }
}
