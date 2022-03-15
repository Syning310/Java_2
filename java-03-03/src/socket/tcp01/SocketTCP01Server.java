package socket.tcp01;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP01Server
{

    //服务端
    public static void main(String[] args) throws IOException
    {
        /*
            思路：
                1、在本机的9999端口监听，等待连接
                2、当没有客户端连接9999端口时，程序会阻塞，等待连接
                3、通过socket.getInputStream()读取客户端写入到数据通道的数据，并显示
        */

        //1、在本机的9999端口监听，等待连接；细节：要求在本机没有其他服务监听9999端口
        ServerSocket sers = new ServerSocket(9999);  //ServerSocket可以用过accept，返回多个Socket对象(多个客户端连接服务器，并发)
        System.out.println("服务端在9999端口监听，等待连接...");


        //2、当没有客户端连接9999端口时，程序会阻塞，等待连接
        //   如果客户端连接，则会返回Socket对象，程序继续
        Socket st = sers.accept();
        System.out.println("服务器端st = " + st.getClass());


        //3、通过socket.getInputStream()读取客户端写入到数据通道的数据，并显示
        InputStream is = st.getInputStream();

        //4、IO读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = is.read(buf)) != -1)
        {
            System.out.println(new String(buf, 0, readLen));
        }


        //关闭流对象，和socket，ServerSocket也要关闭
        sers.close();    //ServerSocket可以accept返回多个Socket
        is.close();
        st.close();

        System.out.println("服务端退出");

    }

}
