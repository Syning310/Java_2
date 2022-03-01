package homework_;

public class Work1
{
    public static void main(String[] args)
    {
        System.out.println("第一次获取序列号： " + Frock.getNextNum());
        System.out.println("第二次获取序列号： " + Frock.getNextNum());

        Frock fk1 = new Frock();
        Frock fk2 = new Frock();
        Frock fk3 = new Frock();
        System.out.println("fk1的序列号为： " + fk1.getSerialNumber());
        System.out.println("fk2的序列号为： " + fk2.getSerialNumber());
        System.out.println("fk3的序列号为： " + fk3.getSerialNumber());


    }
}


class Frock
{
    private int serialNumber;   //序列号

    private static int currentNum;  //出厂的序列号的起始值
    static
    {
        currentNum = 100000;
    }

    public Frock()
    {
        this.serialNumber = Frock.getNextNum();
    }

    public static int getNextNum()
    {
        return currentNum += 100;
    }

    public int getSerialNumber()
    {
        return this.serialNumber;
    }


}
