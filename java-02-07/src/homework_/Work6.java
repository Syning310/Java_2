package homework_;

public class Work6
{
    public static void main(String[] args)
    {
        Car c1 = new Car(50);
        c1.testAirFlow();    //吹冷气

        Car c2 = new Car(-10);
        c2.testAirFlow();    //吹暖气

        Car c3 = new Car(25);
        c3.testAirFlow();    //空调关闭状态

    }
}

class Car
{
    private double temperature;  //车内温度

    public void testAirFlow()
    {
        Air a = new Air();
        a.flow();
    }

    private class Air  //车内空调
    {
        public void flow()
        {
            if (Car.this.temperature >= 40)
            {
                System.out.println("车内空调吹冷气...");
            }
            else if (Car.this.temperature <= 0)
            {
                System.out.println("车内空调吹暖气~~~");
            }
            else
            {
                System.out.println("空调关闭状态");
            }
        }
    }



    public Car() {  }

    public Car(double temperature)
    {
        this.temperature = temperature;
    }

    public double getTemperature()
    {
        return temperature;
    }

    public void setTemperature(double temperature)
    {
        this.temperature = temperature;
    }
}


