package cn.my.test.list_;

import java.util.Vector;

public class Vector_ {
    public static void main(String[] args) {
        // 无参构造器
        Vector vector = new Vector();
        for (int i=0;i<10;i++){
            vector.add(i);

        }

        /*
        *     public Vector() { // 默认情况下初始容量为10
        this(10);
    }
        *
        * add 方法
        *     public synchronized boolean add(E e) {
                    modCount++;
                    ensureCapacityHelper(elementCount + 1);
                    elementData[elementCount++] = e;
                    return true;
        *  扩容
        *     private void ensureCapacityHelper(int minCapacity) { // 确定是否需要扩容
        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
        * */



    }
}
