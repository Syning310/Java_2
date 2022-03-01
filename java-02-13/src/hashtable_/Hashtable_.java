package hashtable_;

import java.util.Hashtable;

public class Hashtable_
{
    public static void main(String[] args)
    {

        Hashtable ht = new Hashtable();
        ht.put("n1", 100);
        //ht.put(null, 100);  //异常
        //ht.put("n2", null); //异常

        ht.put("n3", 100);
        ht.put("n4", 50);
        ht.put("n4", 5000);

        System.out.println(ht);


    }
}
