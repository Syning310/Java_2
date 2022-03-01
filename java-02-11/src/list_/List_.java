package list_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class List_
{
    @SuppressWarnings({"all"})
    public static void main(String[] args)
    {
        //1、List集合类中元素有序(即添加顺序和取出顺序一致)、且可重复
        List lst = new ArrayList();

        lst.add("宁");
        lst.add("宁");
        lst.add("月");
        lst.add("颜");

        System.out.println("lst = " + lst);

        //2、List集合中每个元素都有其对应的顺序索引，即支持索引（底层是数组）
        System.out.println(lst.get(2));  //月




    }
}
