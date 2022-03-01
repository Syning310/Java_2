package io;


import java.io.*;

//BuffredOutputStream 和 BufferedInputStream
public class InputOutput
{

    public static void main(String[] args) throws Exception
    {
        String scrPath = "D:\\图片\\wallpaper\\伞1.jpg";
        String desPath = "D:\\图片\\wallpaper\\copy.jpg";


        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(scrPath));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desPath));


        //循环读取文件，并写入到desPath中
        byte[] buff = new byte[1024];
        int readLen = 0;

        while ((readLen = bis.read(buff)) != -1)
        {
            bos.write(buff, 0, readLen);

        }



        bis.close();
        bos.close();



    }





}






