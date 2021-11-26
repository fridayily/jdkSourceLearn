package cn.my.test.list_;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListCRUD {
    public static void main(String[] args) {
       LinkedList linkedList =new LinkedList();
       linkedList.add(1);
       linkedList.add(2);
       linkedList.add(3);

        System.out.println("linkedlist= "+ linkedList);

        // 演示删除

        linkedList.remove(); // 默认删除第一个
//        linkedList.remove(2);
        System.out.println("linkedlist= "+ linkedList);


        // 修改节点对象

        linkedList.set(1,999);
        System.out.println("linkedlist= "+ linkedList);

        // 得到某个节点对象
        linkedList.get(1);

        // 遍历

        System.out.println("遍历");
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();

            System.out.println("next=" + next);

        }

        for (int i = 0;  i< linkedList.size() ; i++) {
            System.out.println(linkedList.get(i));

        }



/*
*   1. LinkedList linkedList =new LinkedList();
*    public LinkedList() {}
*   2. 这时linklist 的属性 first =null, last =null
*   3. 执行添加
*        public boolean add(E e) {
        linkLast(e);
        return true;
    }
    * 4.将新节点加入双向链表
    *     void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }
    *
    *     public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }
    * 将f 指向的双向链表的第一个节点删掉
    *     private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;
    }
* */
    }
}
