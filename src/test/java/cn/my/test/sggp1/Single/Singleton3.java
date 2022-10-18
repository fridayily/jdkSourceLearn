package cn.my.test.sggp1.Single;

import java.io.IOException;
import java.util.Properties;

/*
 *  饿汉式：
 *  枚举类型：表示该类型的对象是有限几个
 * */
public class Singleton3 {
    public static final Singleton3 INSTANCE;

    private String info;

    static {

        try {

            Properties pro = new Properties();

            // 有问题待解决
            pro.load(Singleton3.class.getClassLoader().getResourceAsStream("single.properties"));

            INSTANCE = new Singleton3(pro.getProperty("info"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private Singleton3(String info){
        this.info = info;

    }
}
