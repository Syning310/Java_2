package exercise;

import java.io.BufferedReader;
import java.io.FileReader;

public class Work2
{

    public static void main(String[] args) throws Exception
    {

        String path = "d:\\行为守则.txt";

        BufferedReader br = new BufferedReader(new FileReader(path));

        String readLine;
        while ((readLine = br.readLine()) != null)
        {
            System.out.println(readLine + "；");
        }


        br.close();


    }

}
