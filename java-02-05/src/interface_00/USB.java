package interface_00;

//认为规定抽象方法
public interface USB
{
    void start();
    void stop();
}

class Phone implements USB
{
    public void start()
    {
        System.out.println("Phone开始工作...");
    }

    public void stop()
    {
        System.out.println("Phone停止工作...");
    }

}

class Camera implements USB
{
    public void start()
    {
        System.out.println("Camera开始工作...");
    }
    public void stop()
    {
        System.out.println("Camera停止工作...");
    }
}

