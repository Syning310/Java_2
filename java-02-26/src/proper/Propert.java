package proper;

import java.io.BufferedReader;
import java.io.FileReader;

public class Propert
{
    public static void main(String[] args) throws Exception
    {

        //读取mysql.properties
        BufferedReader br = new BufferedReader(new FileReader("src\\mysql.properties"));

        String line;
        while ((line = br.readLine()) != null)
        {
            //System.out.println(line);
            String[] spl = line.split("=");
            System.out.println(spl[0] + "值是：" + spl[1]);
        }



        br.close();


    }
}
