package io_stream.writer_;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_
{

    @Test
    public void writer01()
    {
        String path = "d:\\note.txt";

        FileWriter fw = null;

        try
        {
            fw = new FileWriter(path, true);
            String txt = "风雨过后，会见彩虹";
            fw.write(txt.toCharArray());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                fw.close();
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }


    }

}
