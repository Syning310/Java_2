package homework_;

public class Work5
{
    public static void main(String[] args)
    {
        //从交通工具工厂类中获得马儿实例，把马儿实例对象，设置成唐僧的交通工具
        Person p = new Person("唐僧", VeFactory.getHouse());


        System.out.println("在正常情况下...");
        System.out.println("姓名： " + p.getName() + "   交通工具为： " + p.getVesWork());

        System.out.println("---------------------------------");
        System.out.println("在遇到大河的情况下...");
        //换交通工具
        p.setVes(VeFactory.getBoat());
        System.out.println("姓名： " + p.getName() + "   交通工具为： " + p.getVesWork());

    }
}

interface Vehicles
{
    String work();
}

class House implements Vehicles
{
    public String work()
    {
        return "马儿驾驾驾...";
    }
}

class Boat implements Vehicles
{
    public String work()
    {
        return "小船游游游...";
    }
}

class Person
{
    private String name;
    private Vehicles ves;

    Person(String name, Vehicles ves)
    {
        this.name = name;
        this.ves = ves;
    }

    public String getName()
    {
        return this.name;
    }

    public void setVes(Vehicles ves)
    {
        this.ves = ves;
    }

    public String getVesWork()
    {
        return ves.work();
    }

}

class VeFactory
{
    public static House getHouse()
    {
        return new House();
    }
    public static Boat getBoat()
    {
        return new Boat();
    }
}