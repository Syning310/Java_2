package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMethod
{
    @SuppressWarnings({"all"})
    public static void main(String[] args)
    {
        Set set = new HashSet();

        set.add("宁");
        set.add("月");
        set.add("颜");
        set.add("宁"); //重复
        set.add("月"); //重复
        set.add("颜"); //重复

        set.add(null);
        set.add(null); //重复

        // 1、set接口的实现类的对象，不能存放重复的元素，null也只能添加一个
        // 存放数据是无序的，即添加和取出的顺序是不一致的;当然取出的顺序总是一致的
        System.out.println("set = " + set);


        //遍历
        System.out.println("迭代器遍历： ");
        Iterator it = set.iterator();
        while (it.hasNext())
        {
            Object o = it.next();
            System.out.println(o);
        }

        System.out.println("增强for遍历： ");
        for (Object o : set)
        {
            System.out.print(o + "  ");
        }


        set.remove(null);


    }
}
