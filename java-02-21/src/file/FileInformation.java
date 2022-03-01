package file;

import java.io.File;

public class FileInformation
{
    public static void main(String[] args)
    {

        info();

    }

    public static void info()
    {
        File f = new File("d:\\news1.txt");

        //调用相应的方法，得到对应信息
        System.out.println("文件名字 = " + f.getName());
        System.out.println("文件的绝对路径 = " + f.getAbsolutePath());
        System.out.println("文件的父级目录 = " + f.getParent());
        System.out.println("文件的字节大小 = " + f.length());
        System.out.println("文件是否存在 = " + f.exists());
        System.out.println("是不是文件 = " + f.isFile());
        System.out.println("是不是目录 = " + f.isDirectory());

    }
}
