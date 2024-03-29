package cn.my.test.sggp1.Single;


/*
 * (1) 构造器私有化
 * （2） 用一个静态变量保存这个唯一实例
 * (3) 提供一个静态方法，获取这个实例对象
 * */
public class Singleton5 {

    private static Singleton5 instance;

    private Singleton5() {
    }

    public static Singleton5 getInstance() throws InterruptedException {
        if (instance == null) {

            synchronized (Singleton5.class) {
                if (instance == null) {
                    Thread.sleep(1000);
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }

}
