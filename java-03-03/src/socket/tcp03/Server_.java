package socket.tcp03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_
{
    public static void main(String[] args) throws IOException
    {

        //字符流
        //1、编写一个服务器，和一个客户端
        //2、服务端在9000端口监听
        //3、客户端连接到服务器，发送hello server，并接受服务端回发的hello client再退出
        //4、服务端接收到客户端发送的信息，输出，并回发hello client再退出

        System.out.println("监听9000端口");
        ServerSocket sst = new ServerSocket(9000);
        Socket sot = sst.accept();

        //接收
        InputStream is = sot.getInputStream();
        BufferedReader isr = new BufferedReader(new InputStreamReader(is));

        System.out.print("接收消息：");
        int read = 0;
        while ((read = isr.read()) != -1)
        {
            System.out.print((char)read);
        }
        System.out.println();

        //发送
        System.out.println("发送消息成功");
        OutputStream os = sot.getOutputStream();
        BufferedWriter osw = new BufferedWriter(new OutputStreamWriter(os));
        osw.write("你好客户端");
        osw.flush();
        sot.shutdownOutput();



        osw.close();
        isr.close();
        sot.close();
        sst.close();


    }
}
