package cn.my.test.reflection;

import cn.my.test.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 测试反射类型
public class Reflection02 {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, NoSuchMethodException, IllegalAccessException {

//        Field
        m1();
        m2();
        m3();

    }

    // 普通方法调用hi

    public static void m1() {
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();

        System.out.println("m1()：" + (end - start));

    }

    // 反射机制调用hi
    public static void m2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
//
//        properties.load(new FileInputStream("src/main/resources/re.properties"));
//        String classfullpath = properties.getProperty("classfullpath").toString();
//        String methodName =properties.get("method").toString();


        Class cls =  Class.forName("cn.my.test.Cat");

        Object o = cls.newInstance();

        System.out.println("o的运行类型="+ o.getClass()); // 运行类型

        Method hi= cls.getMethod("hi");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            hi.invoke(o); // 反射机制调用
        }
        long end = System.currentTimeMillis();

        System.out.println("m2()：" + (end - start));

    }

    // 反射调用优化 + 关闭访问检查

    public static void m3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {



        Class cls =  Class.forName("cn.my.test.Cat");

        Object o = cls.newInstance();

        System.out.println("o的运行类型="+ o.getClass()); // 运行类型

        Method hi= cls.getMethod("hi");
        hi.setAccessible(true); // 在反射调用方法时，取消访问

        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            hi.invoke(o); // 反射机制调用
        }
        long end = System.currentTimeMillis();

        System.out.println("m2()：" + (end - start));

    }
}
