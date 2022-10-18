package cn.my.test.list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExercise {
    public static void main(String[] args) {
        /*
        *  添加10个以上的元素，在2号位插入一个元素 "韩顺平教育"
        *  获得第5个元素，删除第6个元素，修改第7个元素，在使用迭代器遍历集合
        * */
        List list = new ArrayList();
        for (int i = 0; i < 12; i++) {
            list.add("hello"+i);
        }
        System.out.println("list=" + list);

        list.add(1,"韩顺平教育");

        System.out.println("list=" + list);

        // 获得第5个
        System.out.println("list=" + list.get(4));

        // 删除第6个
        list.remove(5);
        System.out.println("list=" + list);


        // 修改第7个
        list.set(6,"三国演义");

        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println("next"+ next);

        }


    }
}
