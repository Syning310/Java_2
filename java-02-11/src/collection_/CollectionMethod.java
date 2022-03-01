package collection_;

import java.util.ArrayList;

import java.util.List;

public class CollectionMethod
{
    @SuppressWarnings ({"all"})
    public static void main(String[] args)
    {
        List list = new ArrayList();

        //1、添加单个元素  add
        list.add("宁");
        list.add(10);    //list.add(new Integer(10));
        list.add(true);
        list.add("月");

        System.out.println("list = " + list);

        //2、删除指定元素  remove
        list.remove(2);    //删除下标为2的元素
        list.remove(new Integer(10));  //如果是要删除集合中的Integer，就不能自动装箱了，要不然它会优先匹配删除下标的函数

        System.out.println("list = " + list);

        //3、查找元素是否存在   contains
        System.out.println(list.contains("宁"));


        //4、获取集合元素个数   size
        System.out.println(list.size());

        //5、判断是否为空      isEmpty
        System.out.println(list.isEmpty());

        //6、清空   clear
        list.clear();
        System.out.println("list = " + list);

        //7、添加多个元素  addAll    传入的参数是，实现了Collection接口的实现类的对象
        List lst2 = new ArrayList();
        lst2.add("月");
        lst2.add("宁");
        lst2.add("尘");

        list.addAll(lst2);
        System.out.println("list = " + list);


        //8、查找多个元素是否存在  containsAll     传入的参数也是，实现了Collection接口的实现类的对象
        System.out.println(list.containsAll(lst2));

        //9、删除多个元素    removeAll      传入的参数也是，实现了Collection接口的实现类的对象
        list.add("美丽新世界");
        list.removeAll(lst2);
        System.out.println("list = " + list);

    }
}
