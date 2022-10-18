package cn.my.test.reflection.class_;


// Class 类的特点
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {

        //  1.Class 也是类，因此也继承 Obejct 类

        // 2. Class 类对象不是new 出来的，而是系统创建的
        /*
        public Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
    }
        * */
//        Cat cat = new Cat();

        // (2) 反射方式
                /* ClassLoader 类  仍然是通过 ClassLoader 加载cat 类的对象
        public Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
    }
        * */
        Class cls1 = Class.forName("cn.my.test.Cat");


        // 3 对于某个Class 类对象，在内存中只有一份，因为类只加载一次

        Class cls2 = Class.forName("cn.my.test.Cat");
        Class cls3 = Class.forName("cn.my.test.Dog");


        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());

        // 4. 每个类的实例都会记得自己是由哪个Class 实例所生成
        // 5. 通过class 对象可以完整地得到一个类的完整结构，通过一系列API
        // 6. Class 对象是存放在堆的
        // 7. 类的字节码二进制数据，是放在方法区的，有的地方称为类的元数据（包括方法代码，变量名，方法名，访问权限等等）


    }
}
