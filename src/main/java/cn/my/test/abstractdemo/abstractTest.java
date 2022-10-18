package cn.my.test.abstractdemo;

import java.util.Arrays;

public class abstractTest {

    public static void main(String[] args) {
        // 创建以此抽象类为元素的数组
        // 对象数组是存储对象的地址，不涉及实例化，只是规定了数组类型，所以可以实例化抽象类的子类
        Person[] person = new Person[5];
        System.out.println(person[0]);
        Student s1 = new Student();
        s1.setName("zhangsan");
        person[1] = s1;
        System.out.println("person[1]地址: " +person[1]);
        System.out.println("person[2]地址: " +person[2]);
        System.out.println(person[1].getName());


        System.out.println("类：" + person.getClass());
        System.out.println("父类： " + person.getClass().getSuperclass());
        System.out.println("类名： " + person.getClass().getName());


        int[] ints = new int[5];
        System.out.println("int数组变量在栈中，存的是堆的地址：" + ints);
        System.out.println("int数组初始化值：" + ints[0]);
        System.out.println("int数组类名：" + ints.getClass().getName());


        int[] x = new int[3];
        int[] y = new int[3];
        x[0] = 1;
        y[0] = 2;
        System.out.println("1:x " + Arrays.toString(x));
        System.out.println("1:y " + Arrays.toString(y));
        x = y;
        System.out.println("2:x " + Arrays.toString(x));
        System.out.println("2:y 地址 " + y);
        System.out.println("2:y 类型 " + y.getClass());

        y = null;
        System.out.println("3:y " + Arrays.toString(y));
        System.out.println("3:y 地址 " + y);
//        System.out.println("3:y 类型 " + y.getClass());  报错


    }

}
