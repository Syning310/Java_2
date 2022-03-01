package map_;

import java.util.*;

@SuppressWarnings({"all"})
public class Map_For
{
    public static void main(String[] args)
    {
        Map mp = new HashMap();
        mp.put("no1", "宁");
        mp.put("no2", "月");
        mp.put("no3", "尘");
        mp.put("no4", "乐");
        mp.put("no5", "颜");
        mp.put("no6", "龙");

        //第一组：先取出所有的key，然后通过key 取出对应的value
        Set kset = mp.keySet();

        //1、增强for
        for (Object k : kset)
        {
            System.out.print(k + " - " + mp.get(k) + "  ");
        }
        System.out.println();

        //2、迭代器
        Iterator it = kset.iterator();
        while (it.hasNext())
        {
            Object ks = it.next();
            System.out.print(ks + " - " + mp.get(ks) + "  ");
        }
        System.out.println();

        //第二组：把所有的values值取出
        Collection vals = mp.values();
        //这里就可以使用所有的Colleaction使用的遍历方法：增强for、迭代器；只是只有value
        for (Object o : vals)
        {
            System.out.print(o + "  ");
        }
        System.out.println();

        //第三组：通过Entry获取k-v
        Set entrySet = mp.entrySet();
        System.out.println("使用EntrySet的方法");
        //1、增强for
        for (Object en : entrySet)
        {
            //将en 转成 Map.Entry
            Map.Entry m = (Map.Entry)en;
            System.out.print(m.getKey() + " - " + m.getValue() + "  ");
        }
        System.out.println();

        //2、迭代器
        Iterator enIt = entrySet.iterator();
        while (enIt.hasNext())
        {
            Object obj = enIt.next();
            Map.Entry m = (Map.Entry)obj;
            System.out.print(m.getKey() + " - " + m.getValue() + "  ");
        }
        System.out.println();


    }
}
