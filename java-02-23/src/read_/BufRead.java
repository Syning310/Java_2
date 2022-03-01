package read_;


import java.io.BufferedReader;
import java.io.FileReader;

//演示BufferedReader使用
public class BufRead
{
    public static void main(String[] args) throws Exception
    {
        String path = "d:\\行为守则.txt";

        //创建BufferedReader
        BufferedReader bf = new BufferedReader(new FileReader(path));

        //使用bf读取，bf底层是调用FileReader读取
        String line;

        //按行读取，效率更高,返回字符串，为空说明读取完毕

        while ((line = bf.readLine()) != null)
        {
            System.out.println(line);
        }

        //关闭流，只需要关闭外层流即可，因为底层会关闭节点流
        bf.close();

    }


}
