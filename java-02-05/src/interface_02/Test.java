package interface_02;


public class Test
{
    public static void t(Inter in)
    {
        in.connect();
        in.close();
    }
    public static void main(String[] args)
    {
        MysqlDB m = new MysqlDB();

        OrcleDB o = new OrcleDB();

        Test.t(m);
        Test.t(o);

    }
}
