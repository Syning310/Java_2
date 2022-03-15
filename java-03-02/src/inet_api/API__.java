package inet_api;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class API__
{
    public static void main(String[] args)
    {

        try
        {
            //1、获取本机的InetAdress对象
            InetAddress local = InetAddress.getLocalHost();  //LAPTOP-LF1HQG1J/192.168.43.1
            System.out.println(local);


            //2、根据指定主机名，获取InetAdress对象
            InetAddress in = InetAddress.getByName("LAPTOP-LF1HQG1J");
            System.out.println("in = " + in);  //in = LAPTOP-LF1HQG1J/192.168.43.1


            //3、根据域名返回InetAdress对象
            InetAddress byName = InetAddress.getByName("www.baidu.com");
            System.out.println("byName = " + byName);  //byName = www.baidu.com/163.177.151.109


            //4、通过InetAdress对象，获取对应的IP地址
            String strIn = local.getHostAddress();
            System.out.println("strIn = " + strIn);  //strIn = 192.168.43.1


            //5、通过InetAdress对象，获取对应的主机名/域名
            String hostName = local.getHostName();
            System.out.println("hostName = " + hostName);  //hostName = LAPTOP-LF1HQG1J

        }
        catch (UnknownHostException e)
        {
            System.out.println(e.getMessage());
        }






    }
}
