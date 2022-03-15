package exercise.work01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args)
    {

        String enter = "";

        Socket socket = null;
        BufferedWriter bw = null;
        BufferedReader br = null;
        Scanner sc = new Scanner(System.in);

        try
        {
            //连接 机子 的端口
            socket = new Socket(InetAddress.getByName("192.168.43.1"), 9999);


            enter = sc.next();
            //利用字符流输出流，输出数据到数据通道
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(enter);
            bw.flush();
            socket.shutdownOutput();


            //利用字符输入流读取服务端返回的内容
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = "";
            while ((str = br.readLine()) != null)
            {
                System.out.println(str);
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
                br.close();
                bw.close();
                socket.close();

            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

        }







    }
}
