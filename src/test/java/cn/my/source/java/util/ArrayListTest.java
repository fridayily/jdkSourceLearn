package cn.my.source.java.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;

class ArrayListTest {

    @BeforeEach
    void setUp() {
    }


    @Test
    void getClassDeclareFields() {
        System.out.println("Declared fields: ");
        Field[] fields = ArrayList.class.getDeclaredFields(); // 获取一个类的所有成员变量，不包括基类
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName());
        }
        System.out.println("-------------------------");

        System.out.println("Public fields: ");
        fields = ArrayList.class.getFields(); // 获取一个类的 public 成员变量 包括基类
        for(int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName()); // 此处结果是color, location
        }

    }


    @Test
    void size() {
        // 使用无参构造器创建 Arraylist 对象
        ArrayList list = new ArrayList(); // 使用无参构造函数，初始elementData容量为0，第一次添加，扩容为 10，再次扩容
        // 则扩容为element 的1.5 倍
        // 如果使用有参构造函数,则初始化elementData指定大小，如需扩容扩容为elementData的1.5倍

        for (int i = 1; i <= 11; i++) {
            list.add(i);
            System.out.println(list.size());
            int length = getArrayListCapacity(list);
            System.out.println("list 长度："+ length);
        }



    }


    @Test
    void add() {

        // 使用无参构造器创建 Arraylist 对象
        ArrayList list = new ArrayList(); // 使用无参构造函数，初始elementData容量为0，第一次添加，扩容为 10，再次扩容
        // 则扩容为element 的1.5 倍
        // 如果使用有参构造函数,则初始化elementData指定大小，如需扩容扩容为elementData的1.5倍

        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        for (int i = 11; i < 15; i++) {
            list.add(i);
        }
        list.add(100);
        list.add(200);
        list.add(null);

        System.out.println("list " + list);
    }


    public static int getArrayListCapacity(ArrayList<?> arrayList) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            //获取 elementData 字段
            Field field = arrayListClass.getDeclaredField("elementData");
            //开始访问权限
            field.setAccessible(true);
            //把示例传入get，获取实例字段elementData的值
            Object[] objects = (Object[])field.get(arrayList);
            //返回当前ArrayList实例的容量值
            return objects.length;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Test
    void trimToSize() {

        ArrayList list = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        list.add(11);
        System.out.println("list size " + list.size() +  " list length " + getArrayListCapacity(list));
        list.trimToSize();
        System.out.println("list size " + list.size() +  " list length " + getArrayListCapacity(list));







    }

    @Test
    void ensureCapacity() {
        ArrayList list = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

    }

    @Test
    void sort() {

        ArrayList list = new ArrayList();
        list.add("A");
        list.add("C");
        list.add("B");
        System.out.println("list "+ list);


        list.sort(Comparator.reverseOrder());

        System.out.println("list "+ list);
    }

    @Test
    void replaceAll(){
        ArrayList list = new ArrayList();
        list.add("A");
        list.add("C");
        list.add("B");
        System.out.println("list "+ list);

        list.replaceAll(a->a+"_list");
        System.out.println("list "+ list);

    }

    @Test
    void removeIf() {
        ArrayList list = new ArrayList();
        list.add("A");
        list.add("C");
        list.add(null);
        list.add("B");
        list.add(null);
        System.out.println("list "+ list);

        list.removeIf(x -> x==null); // 去掉空值
        System.out.println("list "+ list);

    }

    @Test
    void testSize() {
    }
}