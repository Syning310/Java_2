package exercise.work03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{

    public static void main(String[] args)
    {

        String srcPath = "D:\\BaiduNetdiskDownload\\资料\\分享资料\\高山流水.mp3";
        ServerSocket sst = null;
        Socket socket = null;

        BufferedReader brs = null;        //读取客户端来的消息
        BufferedInputStream is = null;    //把歌写入内存
        BufferedOutputStream bos = null;  //输出歌

        try
        {
            //1、服务端监听9966端口
            sst = new ServerSocket(9966);
            socket = sst.accept();

            //4、接收来自客户端的数据
            brs = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String strData = "";
            String conent = "";  //客户端发来的数据
            while ((strData = brs.readLine()) != null)
            {
                conent += strData;
            }

            //5、判断数据，然后返回给客户端
            if ("高山流水".equals(conent))
            {
                //利用字节输出流，传给客户端歌曲
                is = new BufferedInputStream(new FileInputStream(srcPath)); //先把歌读入内存
                byte[] arrays = streamToByteArray(is);  //得到整首歌的字节内容
                //System.out.println("这首歌是: " + arrays.length + " 个字节");

                bos = new BufferedOutputStream(socket.getOutputStream());
                bos.write(arrays);  //把整首歌的内容写如数据通道
                socket.shutdownOutput();  //设置结束标识
            }
            else
            {
                is = new BufferedInputStream(new FileInputStream("D:\\BaiduNetdiskDownload\\资料\\分享资料\\无名.mp3"));
                byte[] arrays = streamToByteArray(is);

                bos = new BufferedOutputStream(socket.getOutputStream());
                bos.write(arrays);
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
                bos.close();
                is.close();
                brs.close();
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
