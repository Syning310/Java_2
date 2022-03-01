package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings({"all"})
public class Collections_0
{
    public static void main(String[] args)
    {
        List lst = new ArrayList();

        lst.add("宁");
        lst.add("月");
        lst.add("尘");
        lst.add("青");
        lst.add("空");

        System.out.println("反转之前： " + lst);

        Collections.reverse(lst);
        System.out.println("反转之后： " + lst);

        Collections.shuffle(lst);
        System.out.println("打乱之后： " + lst);

        Collections.swap(lst, 0, 4);
        System.out.println("交换第0个和第4个： " + lst);

        Collections.sort(lst, new Comparator()
                                    {
                                        @Override
                                        public int compare(Object v1, Object v2)
                                        {
                                            return ((String)v1).compareTo((String)v2);
                                        }
                                    });

        System.out.println("传入匿名内部类之后： " + lst);


        System.out.println("自然顺序的最大元素是： " + Collections.max(lst));
        System.out.println("自然顺序的最小元素是： " + Collections.min(lst));



    }
}
