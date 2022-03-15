package socket.tcp01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SockTCP01Client
{
    public static void main(String[] args) throws IOException
    {

        /*
            思路：
                1、连接服务端（ip，端口）
                2、连接上后，生成Socket，通过 socket.getOutputStream()
                3、通过输出流，写入数据到数据通道
         */


        //1、连接服务端（ip，端口）
        //解读：连接本机的9999端口，如果连接成功，返回Socket对象
        Socket s = new Socket(InetAddress.getLocalHost(), 9999);  //因为是同一台机子，所以取出本机的ip即可，如果是连接其他机子，则要输入ip
        System.out.println("客户端s = " + s.getClass());

        //2、连接上后，生成Socket，通过 socket.getOutputStream()
        //得到和 s 对象关联的输出流对象
        OutputStream os = s.getOutputStream();

        //3、通过输出流，写入数据到数据通道
        os.write("hello server".getBytes());

        //4、必须关闭流对象，和socket，否则会造成资源浪费
        os.close();
        s.close();
        System.out.println("客户端退出...");


    }
}
