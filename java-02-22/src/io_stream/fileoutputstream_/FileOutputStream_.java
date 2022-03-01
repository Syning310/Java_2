package io_stream.fileoutputstream_;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_
{

    /**
     *演示使用FileOutputStream将数据写到文件中
     *如果文件不存在，则会创建文件
     */
    @Test
    public void writeFile()
    {
        String path = "d:\\a.txt";

        //创建FileOutputSream对象
        FileOutputStream fos = null;

        try
        {
            fos = new FileOutputStream(path);

            //写入一个字节
            fos.write('s');
            fos.write('y');
            fos.write('n');
            fos.write('i');
            fos.write('n');
            fos.write('g');


            //写入字符串
            String str = "\nSyning310@gmail.com";
            //str.getBytes()  可以把字符串转成字节数组
            fos.write(str.getBytes());

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                fos.close();
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }


        try
        {
            fos = new FileOutputStream(path, true);
            String s = "\nas long as you love me";
            fos.write(s.getBytes());

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                fos.close();
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }



    }

}
