package cn.my.test.list_;

import java.util.ArrayList;
import java.util.List;

public class ListExercise02 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("三国演义","罗贯中",10.1));
        list.add(new Book("小李飞刀","古龙",5.1));
        list.add(new Book("红楼梦","曹雪芹",34.1));
        list.add(new Book("西游记","吴",32));


        // 如何对集合进行排序
        for (Object o : list) {
            System.out.println("o=" + o);

        }

        sort(list);
        System.out.println("==排序后==");
        for (Object o : list) {
            System.out.println(o);
        }
    }


    public static void sort(List list){

        int i=0;
        int j=0;
        int listSize= list.size();
        for( i=0;i<listSize-1;i++){
            for(j=0;j<listSize-1-i;j++){
                // 取出对象
                Book book1 = (Book)list.get(j);
                Book book2 = (Book)list.get(j+1);
                if(book1.getPrice()>book2.getPrice()){
                    list.set(j,book2);
                    list.set(j+1,book1);
                }
            }
        }
    }

}
