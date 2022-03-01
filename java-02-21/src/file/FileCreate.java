package file;

import java.io.File;
import java.io.IOException;

public class FileCreate
{
    //演示创建文件
    public static void main(String[] args)
    {

        create01();
        create02();
        create03();

    }

    //方法1   new File(String pathname);
    public static void create01()
    {
        String filePath = "d:\\news1.txt";
        File file = new File(filePath);

        try
        {
            file.createNewFile();
            System.out.println("文件创建成功");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }

    //方法2   new File(File parent, String child);  //根据父目录文件 + 子路径构建
    public static void create02()
    {
        File parent = new File("d:\\");
        File cfile = new File(parent, "news2.txt");

        try
        {
            cfile.createNewFile();
            System.out.println("文件创建成功");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    //方法3   new File(String parent, String child);  //根据父目录 + 子路径构建
    public static void create03()
    {
        String parent = "d:\\";
        String fileName = "news3.txt";
        File f = new File(parent, fileName);

        try
        {
            f.createNewFile();
            System.out.println("文件创建成功");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }


    }


}
