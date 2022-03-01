package treeset_;

import java.util.Comparator;
import java.util.TreeSet;

@SuppressWarnings({"all"})
public class TreeSet_0
{
    public static void main(String[] args)
    {

        TreeSet ts = new TreeSet();

        //添加数据
        ts.add("宁");
        ts.add("颜");
        ts.add("月");
        ts.add("宁");
        //当我们使用无参构造器，创建TreeSet时，仍然是无序的
        System.out.println("ts = " + ts);

        //如果希望添加的元素按照字符串大小来排序，可以使用TreeSet提供的一个构造器，可以传入一个比较器 接口(Comparator)
        TreeSet ts2 = new TreeSet(new Comparator()
                                        {
                                            @Override
                                            public int compare(Object v1, Object v2)
                                            {
                                                //调用String的compareTo方法，进行字符串大小比较；
                                                return ((String)v1).compareTo((String)v2);
                                            }
                                        });
        ts2.add("am");
        ts2.add("delete");
        ts2.add("create");
        ts2.add("breather");
        //此时就是有序的了
        System.out.println("ts2 = " + ts2);




    }
}
