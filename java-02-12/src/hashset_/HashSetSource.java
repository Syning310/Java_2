package hashset_;

import java.util.HashSet;

public class HashSetSource
{
    public static void main(String[] args)
    {

        HashSet hs = new HashSet();

        hs.add("java");
        hs.add("c++");
        hs.add("java");

        System.out.println("hs = " + hs);

        //1、new HashSet(); 执行的是创建一个HashMap
        //2、执行add，它会调用put(e, PRESENT);  PRESENT没有什么意义，只是起到一个占位的作用，重要的是e
        //3、执行public V put(K key, V value);  这里会调用return putVal(hash(key), key, value, false, true);
        //4、hash(key) 得到key对应的hash值
        //
        /*      final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
            Node<K,V>[] tab; Node<K,V> p; int n, i;     //定义辅助变量
            //table就是HashMap的一个数组，类型是Node[]
            //if语句表示如果当前table为空，或者大小==0；那进行第一次扩容，16个空间
            if ((tab = table) == null || (n = tab.length) == 0)
                n = (tab = resize()).length;
            //1、根据key，得到hash 来计算key应该存放到table表的哪个索引位置，并把这个位置，返回给p
            //2、如果p为空，表示还没有存放元素，那就创建一个Node(hash, key = "java", value = PRESENT, null);  //hash是后面做对比用的
            if ((p = tab[i = (n - 1) & hash]) == null)
                tab[i] = newNode(hash, key, value, null);
            else {  //遇到相同的hash值的情况，会进入这条语句
                Node<K,V> e; K k;
                if (p.hash == hash &&   //如果当前索引位置对应的链表的第一个元素，和待添加的key的hash值相同并且满足(待添加的k和p指向的Node结点的k是同一个对象)
                    ((k = p.key) == key || (key != null && key.equals(k))))  //p指向的结点和key的equals和待添加的key比较相同，这种情况就不能加入
                    e = p;
                else if (p instanceof TreeNode)    //再判断 p 是不是一棵红黑树，如果是红黑树，就调用putTreeVal，来进行添加
                    e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                else {  //如果table对应索引的位置，已经是一个链表了，那就使用for循环比较
                        //1、依次和该链表的每个元素进行比较，如果都不相同
                    for (int binCount = 0; ; ++binCount) {
                        if ((e = p.next) == null) {
                            p.next = newNode(hash, key, value, null);
                            //把元素添加到链表后，立刻判断，该链表是否已经达到8个结点
                            //如果达到了，就调用treeifyBin 对当前这个链表进行树化(转成红黑树)
                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                treeifyBin(tab, hash);   //在转成红黑树时，还进行判断，如果tab数组的大小小于64，那就进行数组扩容
                            break;
                        }
                        if (e.hash == hash &&  //如果有相同的情况，就直接break
                            ((k = e.key) == key || (key != null && key.equals(k))))
                            break;
                        p = e;
                    }
                }
                if (e != null) { // existing mapping for key
                    V oldValue = e.value;
                    if (!onlyIfAbsent || oldValue == null)
                        e.value = value;
                    afterNodeAccess(e);
                    return oldValue;
                }
            }
            ++modCount;
            if (++size > threshold)
                resize();
            afterNodeInsertion(evict);
            return null;
        }
        */

    }

}
