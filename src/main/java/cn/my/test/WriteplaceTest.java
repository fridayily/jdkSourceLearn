package cn.my.test;

import java.util.ArrayList;
import java.io.*;

class Student implements Serializable {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return name + "(" + age + ")";
    }


    // 实现了 writeReplace 就不用实现  writeObject，因为writeReplace的返回值会被自动写入输出流中，就相当于自动这样调用：writeObject(writeReplace())
    private Object writeReplace() throws ObjectStreamException {
        System.out.println("执行 writeReplace");
        ArrayList<Object> list = new ArrayList<>();
        list.add(name);
        list.add(age);
        return list;
    }

//    public Object readResolve() throws ObjectStreamException {
//        System.out.println(" readResolve 被调用");
//        return 1;
//    }
}

public class WriteplaceTest {

    public static void print(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.buf"))) {
            Student p = new Student("lala", 33);
            System.out.println("实例化后 调用writeObject");
            oos.writeObject(p);
            oos.close();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.buf"))) {
            System.out.println("调用 readObject");
            print(ois.readObject().toString());
        }
    }
}

