package cn.my.test.set_;

import java.util.HashSet;

public class HashSetSource {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");

        System.out.println("set=" + hashSet);

        /*
        *
       1.执行HashSet()
             public HashSet() {
        map = new HashMap<>();
    }
      2.执行
        public boolean add(E e) { // e= "java"
        return map.put(e, PRESENT)==null; // （static） PRESENT = new Object()
    }
      3.执行 put()  该方法得到key对应的hash值， 算法h = (h = key.hashCode()) ^ (h >>> 16)
        public V put(K key, V value) { key = "java" value = PRESENT
        return putVal(hash(key), key, value, false, true);
    }
      4. putVal
          final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length; // 1. 空表的话，再去 resize() 进行初始化
        if ((p = tab[i = (n - 1) & hash]) == null) // (n - 1) & hash 就是哈希寻桶位置的实现 如果桶中不包含键值对节点引用，则将新键值对节点的引用存入桶中即可
            tab[i] = newNode(hash, key, value, null);
        else { // 发生哈希冲突
            Node<K,V> e; K k; //如果键的值以及节点 hash 等于链表中的第一个键值对节点时，则将 e 指向该键值对
            if (p.hash == hash && // p - 已存储元素，hash - 待存储元素的哈希值
                ((k = p.key) == key || (key != null && key.equals(k)))) // hash值 相等 且 key相等  且 key equal
                e = p; // 第一个节点的值存到 临时节点 e 中
            else if (p instanceof TreeNode) // 如果桶中的引用类型为 TreeNode，则调用红黑树的插入方法
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else { // hash 相等 但key 不等
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) { // 下一个节点为空,则创建一个节点并存值，
                        p.next = newNode(hash, key, value, null);  // 运行此行，e的值为null
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st  当大于 TREEIFY_THRESHOLD 采用树形结构（红黑树）
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash && // 在遍历链表的过程中，看有没有重复元素,有的话跳出来
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e; // 当前节点不能存数，看下一个节点能否存数
                }
            }
            if (e != null) { // existing mapping for key  判断要插入的键值对是否存在 HashMap 中
                V oldValue = e.value;  // 存入后，返回原位置的旧值
                if (!onlyIfAbsent || oldValue == null) // onlyIfAbsent 表示是否仅在 oldValue 为 null 的情况下更新键值对的值
                    e.value = value; // 存入新值
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount; //  只有插入新的值才会改变 modCount
        if (++size > threshold)
            resize(); // size 有没有超过 阈值
        afterNodeInsertion(evict);
        return null;  // 没有旧值 返回null
    }
        * */
    }
}
