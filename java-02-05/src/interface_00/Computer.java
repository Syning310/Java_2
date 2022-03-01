package interface_00;

public class Computer
{
    //电脑中有个工作方法，传入一个接口，这个接口接受实现了USB规范的类
    public void work(USB usb03)
    {
        usb03.start();
        usb03.stop();
    }

}
