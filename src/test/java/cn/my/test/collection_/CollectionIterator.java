package cn.my.test.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIterator {
    public static void main(String[] args) {
        Collection col = new ArrayList();

        col.add(new Book("三国演义","罗贯中",10.1));
        col.add(new Book("小李飞刀","古龙",5.1));
        col.add(new Book("红楼梦","曹雪芹",34.1));

        System.out.println("col="+ col);

        // 遍历
        // 先得到col对应的迭代器
        Iterator iterator = col.iterator();
        // 使用while 循环遍历
        while(iterator.hasNext()){
            // 返回下一个元素
            Object obj = iterator.next();
            System.out.println("obj"+ obj);
        }

        // 快捷键 itit
        // win + J 提示快捷键
//        while (iterator.hasNext()) {
//            Object next =  iterator.next();
//
//        }
        // 如果需要再次遍历，需要重置
//        iterator = col.iterator();
    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
