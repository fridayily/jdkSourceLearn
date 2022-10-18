package cn.my.test.collection_;

import java.util.ArrayList;

// ArrayList 是由数组来实现数据存储的
// ArrayList 中维度了一个Obejct 类型的数组 elementData
//    transient Object[] elementData // transient 表示瞬间，短暂的，表示该属性不会被序列化
// 当创建ArrayList对象时，如果使用的是无参构造器，则初始化elementData容量为0，第1次添加，则扩容
// elementData 为10，如需再次扩容，则扩容elementData为1.5
// 如果使用的是指定大小的构造器，则初始化elementData容量为指定大小，如需扩容，则直接扩容为elementData的1.5倍
public class ArrayListDetail {
    public static void main(String[] args) {
        // ArrayList 是线程不安全的 没有 synchronized
        /*
        public boolean add(E e) { // 线程不安全 没有synchronized
        ensureCapacityInternal(size + 1);  // Increments modCount!! 确定是否要扩容
        elementData[size++] = e;
        return true;
    }

        * */
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        arrayList.add("jack");
        arrayList.add("null");

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(2).getClass());
        System.out.println(arrayList.get(0)==arrayList.get(2));

        System.out.println(arrayList);
    }
}
