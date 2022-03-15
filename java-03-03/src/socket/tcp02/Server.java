package socket.tcp02;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        //服务端在9999端口监听
        ServerSocket sst = new ServerSocket(9999);
        System.out.println("服务器在9999端口监听");

        Socket serSk = sst.accept();

        //接收客户端的信息，并回复hello
        System.out.print("接收客户端信息： ");
        InputStream is = serSk.getInputStream();
        byte[] buf = new byte[1024];
        int read = 0;

        //只读一次的话，是不会卡顿的，循环读取才不会卡顿
//        read = is.read(buf);
//        System.out.println(new String(buf, 0, read));

        //因为客户端发来的数据，没有设置一个结束标记，服务端不知道读完了吗
        //所以服务端和客户端都卡在这里
        while ((read = is.read(buf)) != -1)
        {
            System.out.println(new String(buf, 0, read));
        }



        System.out.println("给客户端回复");
        OutputStream os = serSk.getOutputStream();
        os.write("hello client!!!".getBytes());
        //设置结束标识
        serSk.shutdownOutput();


        sst.close();
        serSk.close();
        is.close();
        os.close();
        System.out.println("服务器退出...");


    }
}
