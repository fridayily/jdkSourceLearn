package cn.my.test.list_;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class List_ {
    public static void main(String[] args) {
        // list 集合中的元素有序 可以重复
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        list.add("hsp");
        System.out.println("list=" + list);

        List newlist = new ArrayList();
        newlist.add(1);
        newlist.add(2);
        list.addAll(newlist);



        System.out.println("newlist =" + newlist);

        System.out.println("list =" + list);


        List relist = new ArrayList();
        relist.add("jack");

        list.retainAll(relist); // 保留集合中的元素

        System.out.println("retainAll =" + list);

        list.add("jack");
        list.add("tom");
        list.add("mary");
        list.add("hsp");
        list.removeAll(relist); // 删除集合中的元素
        System.out.println("removeAll =" + list);


        System.out.println("spliterator测试-------------");
        ArrayList<String> arr = new ArrayList<>();

        arr.add("a");
        arr.add("b");
        arr.add("c");
        arr.add("d");
        arr.add("e");
        arr.add("f");
        arr.add("g");

        Spliterator<String> a = arr.spliterator();


//        a.forEachRemaining((n)-> System.out.println(arr.indexOf(n)));
//        System.out.println("---------------------");


        Spliterator<String> b = a.trySplit();

//        System.out.println(b.getComparator());

        a.forEachRemaining((n)-> System.out.println("a split 索引" + arr.indexOf(n)));
        System.out.println("---------------------");
        b.forEachRemaining((n)-> System.out.println("b split 索引" +arr.indexOf(n)));

    }

}
