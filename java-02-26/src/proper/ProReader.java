package proper;

import java.io.FileReader;
import java.util.Properties;

public class ProReader
{
    public static void main(String[] args) throws Exception
    {
        //使用Properties类来读取mysql.properties文件

        //1、创建对象
        Properties p = new Properties();

        //2、加载指定配置文件
        p.load(new FileReader("src\\mysql.properties"));

        //3、把k-v显示到控制台
        p.list(System.out);

        System.out.println("========================");

        //4、根据key获取value
        System.out.println(p.getProperty("user"));

        System.out.println(p.getProperty("pwd"));


    }
}
