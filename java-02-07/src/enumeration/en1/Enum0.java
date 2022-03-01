package enumeration.en1;


//自定义枚举

public class Enum0
{
    public static void main(String[] args)
    {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);

    }

}


class Season
{
    private String name;
    private String desc;

    //1、将构造器设为私有，防止外部创建对象
    private Season() {}
    private Season(String name, String desc)
    {
        this.name = name;
        this.desc = desc;
    }
    //2、不提供set方法

    //3、在Season内部，直接创建固定的对象，用static + final修饰
    public static Season SPRING = new Season("春天", "温暖");
    public static Season SUMMER = new Season("夏天", "炎热");
    public static Season AUTUMN = new Season("秋天", "凉爽");
    public static Season WINTER = new Season("冬天", "寒冷");

    @Override
    public String toString() {
        return "Season{" + "name='" + this.name + '\'' + ", desc='" + this.desc + '\'' + '}';
    }
}
