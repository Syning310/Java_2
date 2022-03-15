package exercise.work01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String[] args)
    {

        ServerSocket sst = null;
        Socket socket = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        try
        {
            //监听端口
            sst = new ServerSocket(9999);
            socket = sst.accept();

            //利用字符输入流，从数据通道输入数据
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = "";
            String strData = "";

            //判断客户端发来的消息，返回对应的内容
            while ((str = br.readLine()) != null)
            {
                strData += str;
            }
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            if ("name".equals(strData))
            {
                bw.write("我是尚亦宁");
                bw.flush();
                socket.shutdownOutput();
            }
            else if ("hobby".equals(strData))
            {
                bw.write("编写java程序");
                bw.flush();
                socket.shutdownOutput();
            }
            else
            {
                bw.write("你说啥呢？");
                bw.flush();
                socket.shutdownOutput();
            }


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                bw.close();
                br.close();
                socket.close();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

        }






    }
}
