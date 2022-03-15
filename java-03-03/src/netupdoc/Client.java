package netupdoc;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


public class Client
{
    static InputStream is = null;
    static OutputStream os = null;
    public static void main(String[] args) throws Exception
    {

        /*
            1、编写一个服务端，和一个客户端
            2、服务端在8888端口监听
            3、客户端连接到服务端，发送一张图片 d:\\图片\\剑\\背影.jpg
            4、服务器接收到客户端发送的图片，保存到d:\\下，然后发送“收到图片”再退出
            5、客户端接收到服务端发送的收到图片，再退出
         */

        String path = "d:\\图片\\剑\\背影.jpg";
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);


        //第一
        //读取图片
        is = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(is);

        //将图片保存到byte[]数组中
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //通过socket获取输出流，将bytes数据发送给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        bos.write(bytes);  //将文件对应的字节数组，写入到数据通道
        socket.shutdownOutput();  //结束标识

        //关闭输入流，这里关闭的是图片文件的路径
        bis.close();





        InputStream input = socket.getInputStream();

        String str = StreamUtils.streamToString(input);

        System.out.println(str);


        input.close();
        bos.close();
        socket.close();




        //第二
//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
//        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
//
//        byte[] bytes = new byte[1024];
//        int readLen = 0;
//        while ((readLen = bis.read(bytes)) != -1)
//        {
//            bos.write(bytes, 0, readLen);
//        }
//        socket.shutdownOutput();
//
//        bis.close();
//
//        InputStream i = socket.getInputStream();
//        BufferedReader br = new BufferedReader(new InputStreamReader(i));
//
//        String str = "";
//        while ((str = br.readLine()) != null)
//        {
//            System.out.println(str);
//        }
//
//
//        br.close();
//        //bos.close();    //br和bos关闭的都是同一个socket，关闭两次会出现异常
//        socket.close();



        //第三
//        is = new FileInputStream(path);
//        os = socket.getOutputStream();
//
//        byte[] bs = new byte[1024];
//        int read = 0;
//        while ((read = is.read(bs)) != -1)
//        {
//            os.write(bs, 0, read);
//        }
//
//        socket.shutdownOutput();
//
//        //关闭从磁盘读取的流
//        is.close();
//
//
//        is = socket.getInputStream();
//        BufferedReader bis = new BufferedReader(new InputStreamReader(is));
//        String str = "";
//        while ((str = bis.readLine()) != null)
//        {
//            System.out.println(str);
//        }
//
//
//        os.close();
//        bis.close();
//        socket.close();




    }
}
