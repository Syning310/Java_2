package homework_;

import java.util.Scanner;

public class Work7
{
    public static void main(String[] args)
    {
        Color[] cArrs = Color.values();
        for (Color r : cArrs)
        {
            System.out.println(r.show());
        }

        Scanner sc = new Scanner(System.in);
        String col = sc.next();

        Color cr = Color.valueOf(col);  //把字符串变成枚举对象
        switch (cr)
        {
            case RED:
                System.out.println("红色");
                break;
            case BLUE:
                System.out.println("蓝色");
                break;
            case BLACK:
                System.out.println("黑色");
                break;
            case YELLOW:
                System.out.println("黄色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
            default:
                System.out.println("输入错误");
                break;
        }


    }
}

interface IS
{
    String show();
}


enum Color implements IS
{
    RED(255, 0, 0), BLUE(0, 0, 255), BLACK(0, 0, 0), YELLOW(255, 255, 0), GREEN(0, 255, 0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    Color() { }
    Color(int redValue, int greenValue, int blueValue)
    {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    public String toString()
    {
        return this.name() + ": " + this.redValue + ", " + this.greenValue + ", " + this.blueValue;
    }

    public String show()
    {
        return this.toString();
    }


}



