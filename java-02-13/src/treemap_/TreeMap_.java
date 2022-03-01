package treemap_;

import java.util.Comparator;
import java.util.TreeMap;

@SuppressWarnings({"all"})
public class TreeMap_
{
    public static void main(String[] args)
    {
        TreeMap tm = new TreeMap();

        tm.put("c1", "宁");
        tm.put("a2", "月");
        tm.put("d3", "尘");
        tm.put("b4", "空");
        tm.put("e5", "青");
        //默认首字母排序
        System.out.println("tm = " + tm);

        //
        TreeMap tm2 = new TreeMap(new Comparator()
                                    {
                                        @Override
                                        public int compare(Object v1, Object v2)
                                        {
                                            return ((String)v1).compareTo((String)v2);
                                        }
                                    });

        tm2.put("b", "空");
        tm2.put("h", "青");
        tm2.put("a", "尘");
        tm2.put("d", "月");
        tm2.put("c", "卿");

        System.out.println("tm2 = " + tm2);


    }
}
