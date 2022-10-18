package cn.my.test.list_;

import java.util.ArrayList;
import java.util.List;

public class ListMethod {
    public static void main(String[] args) {
        List list = new ArrayList<>();

        list.add("张三风");
        list.add("贾宝玉");

        list.add(1,"hsp");
        System.out.println("list= "+ list);

        List list2 = new ArrayList<>();
        list2.add("jack");
        list2.add("tom");

        list.addAll(1,list2);
        System.out.println("list= "+ list);

        // indexOf
        System.out.println(list.indexOf("tom"));

        list.add("hsp");

        System.out.println(list);
        System.out.println(list.lastIndexOf("hsp"));


        list.remove(0);
        System.out.println("list= "+ list);

        list.set(1,"mary");
        System.out.println("list= "+ list);

        List list1 = list.subList(0, 2);
        System.out.println("list= "+ list1);



    }
}
