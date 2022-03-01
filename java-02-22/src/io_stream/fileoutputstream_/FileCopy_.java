package io_stream.fileoutputstream_;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy_
{

    public static void main(String[] args)
    {
        //文件拷贝
        //将d:\\wb.pong 拷贝到 c:\\

        //1、创建文件输入流，将文件读取到程序中
        //2、创建文件输出流，将读取到的文件数据，写入到指定的文件
        //在写程序时，应该是读取部分数据，就写入到指定文件，使用循环


        String srcPath = "d:\\wb.png";
        String desPath = "d:\\下载\\kbkb.png";
        FileInputStream fis = null;
        FileOutputStream fos = null;


        try
        {
            fis = new FileInputStream(srcPath);     //输入
            fos = new FileOutputStream(desPath);    //输出

            //定义一个字节数组，提高效率
            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = fis.read(buf)) != -1)
            {
                //读取到后，就通过fos写入到文件，即一边读一边写
                fos.write(buf, 0, readLen);
            }
            System.out.println("拷贝结束");

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                fis.close();
                fos.close();
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
            catch (NullPointerException n)
            {
                System.out.println(n.getMessage());
            }
        }



    }

}
