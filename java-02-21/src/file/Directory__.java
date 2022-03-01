package file;

import java.io.File;
import java.io.IOException;

public class Directory__
{
    public static void main(String[] args) throws IOException
    {
        //判断 d:\\news1.txt  是否存在，如果存在就删除
        String path = "d:\\news1.txt";
        File f = new File(path);

        f.createNewFile();

        if (f.exists())
        {
            if (f.delete())
            {
                System.out.println("删除成功");
            }
        }
        else
        {
            System.out.println("文件不存在");
        }


    }
}
