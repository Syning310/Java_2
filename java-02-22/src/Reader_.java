

public abstract class Reader_  //抽象类
{
    public void readFile() { }

    public void readString() { }

}

class FileReader_ extends Reader_
{
    public void readFile()
    {
        System.out.println("对文件进行读取...");
    }
}

class StringRead_ extends Reader_
{
    public void readString()
    {
        System.out.println("读取字符串");
    }
}


class Buffer extends Reader_
{
    private Reader_ r;  //属性是Reader_类型

    public Buffer(Reader_ r)
    {
        this.r = r;
    }

    //让方法更加灵活，多次读取文件
    public void readFiles(int num)
    {
        while (num-- > 0)
        {
            r.readFile();
        }
    }

}








