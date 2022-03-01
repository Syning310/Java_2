package list_.linkedlist_;

import java.util.LinkedList;

public class LinkedListUser
{
    public static void main(String[] args)
    {

        LinkedList ls = new LinkedList();

        //添加节点
        ls.add(1);
        ls.add(5);
        ls.add(10);
        ls.add(20);

        System.out.println("ls = " + ls);

        //删除第一个节点
        ls.remove();
        System.out.println("ls = " + ls);


        //修改某个节点的对象
        ls.set(0, 90);
        System.out.println("ls = " + ls);


        //得到双向链表的对象
        Object obj = ls.get(2);
        System.out.println(obj);

    }
}
