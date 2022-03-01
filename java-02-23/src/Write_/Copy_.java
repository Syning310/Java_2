package Write_;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Copy_
{
    public static void main(String[] args) throws Exception
    {
        String srcPath = "d:\\行为守则.txt";
        String desPath = "d:\\copy.txt";


        BufferedReader br = new BufferedReader(new FileReader(srcPath));
        BufferedWriter bw = new BufferedWriter(new FileWriter(desPath));

        String line;
        while ((line = br.readLine()) != null)
        {
            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();



    }
}
