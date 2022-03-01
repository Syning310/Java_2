package map_;

import java.util.HashMap;
import java.util.Map;

public class Map_
{

    public static void main(String[] args)
    {

        Map mp = new HashMap();

        mp.put("no1", "宁");
        mp.put("no2", "月");
        mp.put("no3", "尘");
        mp.put("no1", "Q");

        System.out.println("mp = " + mp);

        System.out.println(mp.get("no3"));


    }
}
