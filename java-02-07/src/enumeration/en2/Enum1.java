package enumeration.en2;

public class Enum1
{
    public static void main(String[] args)
    {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);

        Season s = Season.SPRING;
        System.out.println(s);


    }
}


//使用enum关键字，实现枚举了
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

//    @Override
//    public String toString() {
//        return "Season{" +
//                "name='" + name + '\'' +
//                ", desc='" + desc + '\'' +
//                '}';
//    }
}
