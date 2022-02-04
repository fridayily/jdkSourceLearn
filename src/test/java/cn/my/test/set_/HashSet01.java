package cn.my.test.set_;

import java.util.HashSet;

public class HashSet01 {
    public static void main(String[] args) {


        HashSet set = new HashSet();
        // 1.在执行add方法后，会返回一个boolen值
        // 2.如果添加成功，返回true,否则返回false
        // 3.可以通过remove 指定删除哪个对象
        System.out.println(set.add("john"));
        System.out.println(set.add("lucy"));
        System.out.println(set.add("john"));
        System.out.println(set.add("jack"));
        System.out.println(set.add("rose"));

        set.remove("john");


        System.out.println("hashSet=" + set);

        // HashSet 不能添加相同的元素/数据
        set = new HashSet();
        System.out.println("set=" + set);
        set.add("lucy");
        set.add("lucy");
        set.add(new Dog("tom")); // 两个Dog类不同，可以添加
        set.add(new Dog("tom"));
        System.out.println("set=" + set);

        // 再加深下。非常经典
        // 看源码，做分析
        set = new HashSet();
        set.add(new String("hsp")); // ok
        set.add(new String("hsp")); // 加入不了
        System.out.println("set=" + set);
    }
}

// 定义Dog类
class Dog{
    private String name;
    public Dog(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
