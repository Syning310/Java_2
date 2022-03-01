package list_.linkedlist_;

public class Linked_List
{
    //模拟一个简单的双向链表
    public static void main(String[] args)
    {
        Node n1 = new Node("宁");
        Node n2 = new Node("月");
        Node n3 = new Node("颜");


        //连接三个节点，形成双向链表    n1 -> n2 -> n3      n1 <- n2 <- n3
        n1.next = n2;  //n1 -> n2
        n2.next = n3;  //n2 -> n3

        n3.prev = n2;  //n2 <- n3
        n2.prev = n1;  //n1 <- n2

        //双向链表的 头 尾
        Node first = n1;
        Node last = n3;

        //遍历： 头 -> 尾
        System.out.println("从头到尾");
        Node each = first;
        while (each != null)
        {
            System.out.println(each);
            each = each.next;
        }

        //遍历： 尾 -> 头
        System.out.println("从尾到头");
        each = last;
        while (each != null)
        {
            System.out.println(each);
            each = each.prev;
        }


    }
}


//1、定义一个Node类，
class Node
{
    public Object data;  //真正存放数据的地方
    public Node next;    //指向后一个节点
    public Node prev;    //指向上一个节点

    public Node(Object data)
    {
        this.data = data;
    }
    public String toString()
    {
        return "Node data = " + data;
    }

}

