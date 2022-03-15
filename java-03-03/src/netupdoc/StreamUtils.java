package netupdoc;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamUtils
{

    /**
     * 功能：将输入流转换成byte[] 即可以把文件的内容读入到byte[]
     * @param is
     * @return
     * @throws Exception
     */
    public static byte[] streamToByteArray(InputStream is) throws Exception
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  //创建输出流对象
        byte[] b = new byte[1024];  //字节数组
        int len;
        while ((len = is.read(b)) != -1)  //循环读取
        {
            baos.write(b, 0, len);  //把读取到的数据，写入baos
        }
        byte[] array = baos.toByteArray();
        baos.close();
        return array;
    }


    /**
     * 功能：将InputStream转换成String
     * @param is
     * @return
     * @throws Exception
     */
    public static String streamToString(InputStream is) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder buil = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null)
        {
            buil.append(line + "\r\n");
        }
        return buil.toString();
    }

}
