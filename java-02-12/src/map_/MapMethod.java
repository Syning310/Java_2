package map_;

import java.util.HashMap;
import java.util.Map;

public class MapMethod
{
    @SuppressWarnings({"all"})
    public static void main(String[] args)
    {
        Map mp = new HashMap();

        mp.put("no1", "宁");
        mp.put("no2", "月");
        mp.put("no3", "尘");
        mp.put("no4", "乐");
        mp.put("no3", "颜");
        mp.put("no2", "龙");


        System.out.println("mp = " + mp);

        //remove  根据键值，删除映射关系
        mp.remove("no1");
        System.out.println("mp = " + mp);

        //get    根据键值，获取value
        System.out.println(mp.get("no2"));

        //size   获取元素个数
        System.out.println(mp.size());

        //isEmpty  判断是否为空
        System.out.println(mp.isEmpty());

        //containsKey  查找键值是否存在
        System.out.println(mp.containsKey("no1"));

        //clear  清除
        mp.clear();


    }
}
