package cn.my.test.reflection.question;

import cn.my.test.Cat;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionQuestion {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Properties properties = new Properties();

        properties.load(new FileInputStream("src/main/resources/re.properties"));
        String classfullpath = properties.getProperty("classfullpath").toString();
        String methodName =properties.get("method").toString();


        // 反射
        // 1 加载类 返回Class 类型的对象
        Class cls = Class.forName(classfullpath);
        // 通过 cls 得到加载的类 cn.my.test.Cat 的对象实例
        Cat o = (Cat)cls.newInstance();
        System.out.println("o 的运行类型 "+ o.getClass());

        // 通过 cls 得到你加载的类 cn.my.test.Cat 的methodName "hi" 的对象方法

        Method method1= cls.getMethod(methodName);

        // 通过method1 调用方法：即通过方法对象来实现调用方法
        method1.invoke(o);//



    }
}
