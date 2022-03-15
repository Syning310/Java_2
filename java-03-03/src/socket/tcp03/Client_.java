package socket.tcp03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client_
{
    public static void main(String[] args) throws IOException
    {
        //字符流
        //1、编写一个服务器，和一个客户端
        //2、服务端在9000端口监听
        //3、客户端连接到服务器，发送hello server，并接受服务端回发的hello client再退出
        //4、服务端接收到客户端发送的信息，输出，并回发hello client再退出


        System.out.println("连接到服务器9000端口");
        Socket socket = new Socket(InetAddress.getLocalHost(), 9000);

        //发出
        BufferedWriter osw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        osw.write("你好，服务端");
        osw.flush();   //如果使用了字符流，需要手动刷新，否则数据不会写入数据通道
        socket.shutdownOutput();
        System.out.println("客户端发送完成！！！");



        //接收
        System.out.print("接收到服务端发来的消息：");
        InputStream is = socket.getInputStream();
        BufferedReader isr = new BufferedReader(new InputStreamReader(is));
        int read = 0;
        while ((read = isr.read()) != -1)
        {
            System.out.print((char)read);
        }



        isr.close();
        osw.close();
        socket.close();





    }
}
