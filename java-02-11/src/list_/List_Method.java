package list_;

import java.util.ArrayList;
import java.util.List;

public class List_Method
{
    @SuppressWarnings({"all"})
    public static void main(String[] args)
    {
        List lst = new ArrayList();
        lst.add("宁");
        lst.add("颜");

        //1、void add(int index, Object ele);  在index位置插入ele元素
        lst.add(1, "尘");
        System.out.println("lst = " + lst);

        //2、boolean addAll(int index, Collection eles);  从index位置开始将eles集合中所有元素添加进来
        //List list2 = new ArrayList();
        //list2.add("月");
        //list2.add("卿");
        //lst.add(3, list2);
        //System.out.println("lst = " + lst);

        //3、Object get(int index);  //获取指定index位置的元素
        System.out.println(lst.get(0));

        //4、int indexOf(Object obj);    //返回obj在集合中首次出现的位置
        System.out.println(lst.indexOf("尘"));

        //5、int lastIndexOf(Object obj);    //返回obj在当前集合中末次出现的位置
        lst.add("宁");
        System.out.println("lst = " + lst);
        System.out.println(lst.lastIndexOf("宁"));

        //6、Object remove(int index);    //移除指定index位置的元素，并返回此元素
        lst.remove(0);
        System.out.println("lst = " + lst);

        //7、Object set(int index, Object ele);  //设置指定index位置的元素为ele，相当于是替换,返回被修改前的元素
        lst.set(2, "尚亦宁");
        System.out.println("lst = " + lst);

        //8、List subList(int fromIndex, int toIndex);  //返回从fromIndex到toIndex位置的子集合
        List retLst = lst.subList(0, 1);  //前闭后开
        System.out.println("retLst = " + retLst);



    }
}
