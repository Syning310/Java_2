package anonymous_innerclass;

public class Exercise_2
{
    public static void main(String[] args)
    {
        Cellphone cp = new Cellphone();
        cp.alarmclock(new Bell(){
                        public void ring()
                        {
                            System.out.println("懒猪起床了");
                        }
        });
        cp.alarmclock(new Bell(){
                        public void ring()
                        {
                            System.out.println("小伙伴们上课了");
                        }
        });

    }

}

class Cellphone
{
    public void alarmclock(Bell b)
    {
        b.ring();
    }
}

interface Bell
{
    void ring();
}
