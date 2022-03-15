package netupdoc;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
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

        ServerSocket sst = new ServerSocket(8888);
        Socket socket = sst.accept();

        String path = "d:\\背影.jpg";


        //第一
        //读取客户端发送的数据
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //写入到服务端的磁盘
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
        bos.write(bytes);
        bos.flush();  //刷新


        bos.close();  //关闭流


        //回复收到图片
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("收到图片");
        bw.flush();  //刷新
        socket.shutdownOutput();  //设置结束标识

        bis.close();  //关闭客户端来的通道
        bw.close();
        socket.close();





        //第二
//        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
//
//        byte[] bytes = new byte[1024];
//        int readLen = 0;
//        while ((readLen = bis.read(bytes)) != -1)
//        {
//            bos.write(bytes, 0, readLen);
//        }
//
//        bos.close();
//
//
//        OutputStream o = socket.getOutputStream();
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(o));
//        bw.write("收到图片");
//        bw.flush();
//        socket.shutdownOutput();
//
//        bw.close();
//
//        bis.close();
//
//        socket.close();



        //第三
//        is = socket.getInputStream();
//        os = new FileOutputStream(path);
//
//        byte[] bs = new byte[1024];
//        int read = 0;
//        while ((read = is.read(bs)) != -1)
//        {
//            os.write(bs, 0, read);
//        }
//
//        //socket.shutdownOutput();  //往磁盘写数据，不需要设置结束标识，否则会抛出异常
//
//        os.close();
//
//
//        os = socket.getOutputStream();
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
//        bw.write("收到图片");
//
//        bw.flush();
//        socket.shutdownOutput();
//
//
//        bw.close();
//        is.close();
//        socket.close();




    }

}
