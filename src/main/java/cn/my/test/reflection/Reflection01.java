package cn.my.test.reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection01 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {


        Properties properties = new Properties();

        properties.load(new FileInputStream("src/main/resources/re.properties"));
        String classfullpath = properties.getProperty("classfullpath").toString();
        String methodName =properties.get("method").toString();


       Class cls =  Class.forName(classfullpath);

       Object o = cls.newInstance();

        System.out.println("o的运行类型="+ o.getClass()); // 运行类型

        Method method1= cls.getMethod(methodName);

        System.out.println("--------");
        method1.invoke(o);

        // java.lang.reflect.Field :代表类的成员变量，Field 对象表示某个类的成员变量
        // getField 不能得到私有的属性
        Field ageField = cls.getField("age");
        System.out.println(ageField.get(o)); // 传统写法 对象.成员变量  ，反射： 成员变量对象.get(对象)

        // java.lang.reflect.Constructor : 代表类的构造方法 Constructor 对象表示构造器
        Constructor constructor = cls.getConstructor(); // () 中可以指定构造器参数类型
        System.out.println(constructor);


        Constructor constructor2 = cls.getConstructor(String.class);// 这里传入的String.class 就是 String 类的class 对象
        System.out.println(constructor2); // Cat(String name)



    }
}
