package exercise;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class Work1
{
    public static void main(String[] args) throws Exception
    {

        String path = "d:\\mytemp";

        File f = new File(path);

        if (!f.exists())
        {
            //创建
            if (f.mkdirs())
            {
                System.out.println(path + "  创建成功");
            }
            else
            {
                System.out.println(path + "  创建失败");
            }
        }


        path += "\\hello.txt";
        f = new File(path);


        if (!f.exists())
        {
            if (f.createNewFile())
            {
                System.out.println(path + "  创建成功");

                BufferedWriter bw = new BufferedWriter(new FileWriter(path));
                bw.write("hello world!!!");

                bw.close();
            }
            else
            {
                System.out.println(path + "  创建失败");
            }
        }
        else
        {
            System.out.println(path + "  已存在");
        }








    }
}
