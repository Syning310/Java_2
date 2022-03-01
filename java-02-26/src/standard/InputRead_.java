package standard;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputRead_
{
    public static void main(String[] args) throws Exception
    {

        //将字节流 FileInputStream 转换成字符流 InputStreamReader 指定编码格式gbk/utf-8
        String path = "d:\\行为守则.txt";


        //把FileInputStream转换InputStreamReader
        //指定编码gbk
        InputStreamReader isr = new InputStreamReader(new FileInputStream(path), "utf-8");
        //把InputStreamReader传入BufferedReader
        BufferedReader br = new BufferedReader(isr);

        String s;
        while ((s = br.readLine()) != null)
        {
            System.out.println(s);
        }

        br.close();





//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
//        int readLen = 0;
//        byte[] b = new byte[1024];
//        while ((readLen = bis.read(b)) != -1)
//        {
//            System.out.println(new String(b, 0, readLen));
//        }
//        bis.close();



    }
}
