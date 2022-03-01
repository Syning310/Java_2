package extend_01;


class Computer
{
    Computer(String cpu, String memory, String disk)
    {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    private String cpu;
    private String memory;
    private String disk;

    public String getDetails()
    {
        return "CPU = " + this.cpu + "  内存 = " + this.memory + "  硬盘 = " + this.disk;
    }
}

class PC extends Computer
{
    public PC(String cpu, String memory, String disk, String brand)
    {
        super(cpu, memory, disk);
        this.brand = brand;
    }
    private String brand;  //品牌

    public String getBrand()
    {
        return this.brand;
    }
}

class NotePad extends Computer
{
    public NotePad(String cpu, String memory, String disk, String color)
    {
        super(cpu, memory, disk);
        this.color = color;
    }
    private String color;

    public String getColor()
    {
        return this.color;
    }
}

public class Exercise
{
    public static void main(String[] args)
    {
        System.out.println("===== p =====");
        PC p = new PC("Inter", "惠普", "外星人", "联想");
        System.out.println("p.getDetails() = " + p.getDetails());
        System.out.println("p.getBrand() = " + p.getBrand());

        System.out.println("===== np =====");

        NotePad np = new NotePad("锐龙", "华为", "酷睿", "黄色");
        System.out.println("np.getDetails() = " + np.getDetails());
        System.out.println("np.getColor() = " + np.getColor());


    }
}
