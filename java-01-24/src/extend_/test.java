package extend_;

public class test
{
    public static void main(String[] args)
    {

        Pupil pl = new Pupil("小明", 12, 88.88);

        Graduate ge = new Graduate("大明", 22, 66.66);

        pl.testing();
        pl.showInfo();

        System.out.println("=============");

        ge.testing();
        ge.showInfo();


    }
}
