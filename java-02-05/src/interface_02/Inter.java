package interface_02;

public interface Inter
{
    void connect();
    void close();
}

class MysqlDB implements Inter
{
    public void connect()
    {
        System.out.println("连接mysql");
    }
    public void close()
    {
        System.out.println("关闭mysql");
    }
}

class OrcleDB implements Inter
{
    public void connect()
    {
        System.out.println("连接oracle");
    }
    public void close()
    {
        System.out.println("关闭oracle");
    }
}

