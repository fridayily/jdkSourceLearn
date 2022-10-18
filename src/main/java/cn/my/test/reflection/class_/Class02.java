package cn.my.test.reflection.class_;

import cn.my.test.Car;

import java.lang.reflect.Field;

// 演示Class 类的常用方法
public class Class02 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        String classAllPath = "cn.my.test.Car";
        // 获取到Car 类，对于的Class 对象
        Class<?> cls = Class.forName(classAllPath);
        // 输出cls

        System.out.println(cls); // 显示cls 对象，是哪个类的Class 对象
        System.out.println(cls.getClass()); // 输出cls运行类型 java.lang.Class

        // 3.得到包名

        System.out.println(cls.getPackage().getName());

        // 4. 得到全类名
        System.out.println(cls.getName());
        // 5. 通过cls 创建对象实例
        Car car = (Car) cls.newInstance();
        System.out.println(car);

        // 6. 通过反射获取属性
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));

        // 7. 通过反射给属性赋值
        brand.set(car, "奔驰");
        System.out.println(brand.get(car));
        System.out.println("=======所有字段属性=======");

        // 8 希望可以得到所有属性(字段)
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

    }
}
