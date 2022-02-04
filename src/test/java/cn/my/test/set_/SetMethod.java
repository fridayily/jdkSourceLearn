package cn.my.test.set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMethod {
    public static void main(String[] args) {
        Set set = new HashSet();
        // 以set 接口的实现类 hashset 来讲set 接口方法
        // set 接口实现类对象 不能存放重复的元素 可以添加一个null
        // set 接口对象存放数据是无序的(添加和取出顺序不一致)
        // 注意： 取出的顺序是固定的虽然不是添加的顺序 但是他是固定的
        set.add("jhon");
        set.add("lucy");
        set.add("jhon");
        set.add("jack");
        set.add(null);
        set.add(null);

        set.remove(null);

        for (int i = 0; i < 10; i++) {
            System.out.println("set= "+ set);

        }

        // 遍历
        // 1.迭代器
        System.out.println("====使用迭代器====");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println("next "+ next);
            
        }
        // 增强for
        System.out.println("====增强for====");
        for (Object o : set) {
            System.out.println("o= "+ o);

        }

        // set 接口对象不能通过索引获取


    }

}
