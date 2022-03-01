package hashset_;


//模拟一个HashSet的底层，HashSet的底层结构是HashMap
public class HashSetStructure
{
    public static void main(String[] args)
    {

        //1、创建一个数组，数组的类型是 Node[]
        Node[] table = new Node[16];

        //2、创建节点
        Node ning = new Node("宁", null);
        //把结点放到表的索引2的位置
        table[2] = ning;

        Node yan = new Node("颜", null);
        //3、将yan挂载到ning
        ning.next = yan;

        Node yue = new Node("月", null);
        //4、将yue挂载到yan
        yan.next = yue;

        Node chen = new Node("尘", null);
        table[3] = chen;


    }
}

class Node  //节点：存储数据、指向下一个节点 (单链表)
{
    Object item;
    Node next;

    public Node(Object item, Node next)
    {
        this.item = item;
        this.next = next;
    }
}
