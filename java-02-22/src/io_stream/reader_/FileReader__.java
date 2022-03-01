package io_stream.reader_;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

public class FileReader__
{


    @Test
    public void read01()
    {

        String path = "d:\\行为守则.txt";

        FileReader fr = null;

        try
        {
            fr = new FileReader(path);
            int readLen = 0;

            while ((readLen = fr.read()) != -1)
            {
                System.out.print((char)readLen);
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                fr.close();
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }

    }

    @Test
    public void read02()
    {

        String path = "d:\\行为守则.txt";

        FileReader fr = null;

        try
        {
            fr = new FileReader(path);
            int readLen = 0;
            char[] ch = new char[1024];
            while ((readLen = fr.read(ch)) != -1)
            {
                System.out.print(new String(ch, 0, readLen));
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                fr.close();
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }

    }

}
