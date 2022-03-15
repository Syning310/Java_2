package exercise.work03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client
{

    public static void main(String[] args)
    {
        String name = "高山流水";
        String desPath = "d:\\消愁.mp3";
        Socket socket = null;

        BufferedWriter bws = null;   //写给服务端
        InputStream input = null;   //读从服务端来的数据
        BufferedOutputStream bos = null;  //写到磁盘的字节流
        try
        {
            //2、客户端连接服务端的ip地址的端口
            socket = new Socket(InetAddress.getByName("192.168.43.1"), 9966);

            //3、用字符输出流，给服务端一个音乐名,name
            bws = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bws.write(name);
            bws.flush();
            socket.shutdownOutput();


            //6、读取从服务端来的数据,用字节输入流
            input = socket.getInputStream();
            //整首歌放入字节数组中
            byte[] arrays = streamToByteArray(input);

            //7、把歌曲写到d盘中
            bos = new BufferedOutputStream(new FileOutputStream(desPath));
            bos.write(arrays);


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                bos.close();
                input.close();
                bws.close();

                socket.close();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }




    }



    public static byte[] streamToByteArray(InputStream is) throws Exception{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();//创建输出流对象
        byte[] b = new byte[1024];//字节数组
        int len;
        while((len=is.read(b))!=-1){//循环读取
            bos.write(b, 0, len);//把读取到的数据，写入bos
        }
        byte[] array = bos.toByteArray();//然后将bos 转成字节数组
        bos.close();
        return array;
    }

}
