package socket.tcp02;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client
{

    public static void main(String[] args) throws IOException
    {

        //连接服务端 9999端口
        Socket clSk = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端连接9999端口");


        //发送hello server，并接口服务端回复的信息，
        System.out.println("给服务端发送信息");
        OutputStream os = clSk.getOutputStream();
        os.write("hello server".getBytes());
        //设置结束标记
        clSk.shutdownOutput();


        System.out.print("接收服务端回复： ");
        InputStream is = clSk.getInputStream();
        byte[] ch = new byte[1024];
        int read = 0;
        while ((read = is.read(ch)) != -1)
        {
            System.out.println(new String(ch, 0, read));
        }



        clSk.close();
        os.close();
        is.close();

        System.out.println("客户端退出...");


    }
}
