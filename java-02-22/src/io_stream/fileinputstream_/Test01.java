package io_stream.fileinputstream_;


import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

//演示FileInputStream的使用(字节输入流   文件 -> 程序)
public class Test01
{
    public static void main(String[] args)
    {


    }


    //使用read()读取
    @Test
    public void readFile01()
    {
        String path = "d:\\hello.txt";

        int data = 0;

        FileInputStream fis = null;
        try
        {
            //创建输入流对象，用于读取文件
            fis = new FileInputStream(path);//编译异常
            //如果返回-1表示读取完毕
            while ((data = fis.read()) != -1)
            {
                //转成char打印
                System.out.print((char)data);
                //中文会出现乱码，因为字节流读取，是一个字节一个字节，中文一个字是三个字节，所以乱码
                //所以读取文件应该用字符流
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            //当文件完成读取之后，应该将流对象关闭释放文件连接
            //关闭文件流，释放资源，应当在finally中，因为finally是必定执行的代码块
            try
            {
                fis.close();
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }

    }



    //使用read(byte[] b)  读取文件，提高效率
    //此方法，从该输入流读取最多b.length字节的数据到字节数组，此方法将阻塞，直到某些输入可用
    @Test
    public void readFile02()
    {
        String path = "d:\\hello.txt";

        //一次读取8个字节
        byte[] buff = new byte[8];
        int readLen = 0;

        FileInputStream fis = null;
        try
        {
            //创建输入流对象，用于读取文件
            fis = new FileInputStream(path);//编译异常

            //如果返回-1表示读取完毕，如果读取正常，返回实际读取的字节数，
            while ((readLen = fis.read(buff)) != -1)
            {
                //转成String打印,String应该按照0号下标到读取的字节数来构建，因为数组不会把之前的数据清空
                System.out.print(new String(buff, 0, readLen));
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            //当文件完成读取之后，应该将流对象关闭释放文件连接
            //关闭文件流，释放资源，应当在finally中，因为finally是必定执行的代码块
            try
            {
                fis.close();
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }

    }

}
