package proper;

import java.io.FileOutputStream;
import java.util.Properties;

public class ProWriter
{
    public static void main(String[] args) throws Exception
    {

        //使用Properties类来创建配置文件，修改配置文件内容

        Properties per = new Properties();

        //创建k-v
        per.setProperty("charset", "utf8");
        per.setProperty("user", "宁");    //注意 中文保存时是unicode码值
        per.setProperty("pwd", "161616");
        //Hashtable的子类，要修改value，只需要key值相同就能覆盖原来的值

        //将k-v存储到文件中
        per.store(new FileOutputStream("src\\yue.properties"), null);   //null是注释，最上面那行

        System.out.println("文件配置成功!!!!");


    }
}
