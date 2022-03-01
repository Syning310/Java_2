package Write_;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufWriite
{

    public static void main(String[] args) throws Exception
    {

        String path = "d:\\hello.txt";

        BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));

        bw.write("Hello World!!!");
        bw.write("\nI like you");



        bw.close();



    }

}
