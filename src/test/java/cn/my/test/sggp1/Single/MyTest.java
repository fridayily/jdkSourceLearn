package cn.my.test.sggp1.Single;

public class MyTest {

    public static void main(String[] args) {
        Singleton1 s = Singleton1.INSTANCE;
        System.out.println(s);


        // 枚举类型
        Singleton2 instance = Singleton2.INSTANCE;

        System.out.println(instance);
        System.out.println(instance.hashCode());


        Singleton3 instance1 = Singleton3.INSTANCE;
        System.out.println(instance1);




    }
}
