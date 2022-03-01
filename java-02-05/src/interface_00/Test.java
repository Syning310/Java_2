package interface_00;

public class Test
{
    public static void main(String[] args)
    {
       Computer cp = new Computer();

       Phone p = new Phone();
       Camera c = new Camera();


       cp.work(p);  //把手机，接入到计算机
        System.out.println("------------------");
       cp.work(c);  //把相机，接入到计算机

    }

}
