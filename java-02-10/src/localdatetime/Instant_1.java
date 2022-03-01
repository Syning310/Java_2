package localdatetime;

import java.time.Instant;
import java.util.Date;

public class Instant_1
{
    public static void main(String[] args)
    {


        Instant now = Instant.now();

        System.out.println(now);

        Date d = Date.from(now);

        //System.out.println(d);

        Instant ins = d.toInstant();
        System.out.println(ins);



    }
}
