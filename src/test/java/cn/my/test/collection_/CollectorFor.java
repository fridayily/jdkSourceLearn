package cn.my.test.collection_;

import java.util.ArrayList;
import java.util.Collection;

public class CollectorFor {
    public static void main(String[] args) {

        Collection col = new ArrayList();

        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古龙", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.1));

        System.out.println("col=" + col);

        // 使用增强for,在Collection 集合
        // 增强for 也是迭代器
        // 简化版本的迭代器
        // 快捷  I   col.for


        for (Object book : col) {
            System.out.println("book=" + book);
        }
        // 增强for也可以直接在数组使用
        int[] nums = {1, 8, 10, 90};
        for (int i : nums) {
            System.out.println("i=" + i);
        }
    }
}
