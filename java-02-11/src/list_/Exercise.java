package list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exercise
{
    @SuppressWarnings({"all"})
    public static void main(String[] args)
    {
        List lt = new ArrayList();
        for (int i = 0; i < 10; ++i)
        {
            lt.add("hello");
        }
        System.out.println("lt = " + lt);

        //1、在2号位插入一个元素 宁
        lt.add(2, "宁");
        System.out.println(("1、lt = " + lt));

        //2、获得第5个元素
        System.out.println("2、" + lt.get(4));

        //3、删除第6个元素
        System.out.println("3、" + lt.remove(5));

        //4、修改第7个元素
        System.out.println("4、" + lt.set(6, "颜"));

        StringBuilder sb = new StringBuilder();
        Iterator it = lt.iterator();

        while (it.hasNext())
        {
            Object o = it.next();
            sb.append((String)o);
            sb.append("、 ");
        }

        System.out.println(sb);

    }
}
