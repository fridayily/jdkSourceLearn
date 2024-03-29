package cn.my.test.sggp1.Single;


/*
*
* 在内部类被加载和初始化时，才创建INSTANCE实例对象
* 静态内部类不会自动随着外部类的加载和初始化而初始化，它是要单独取加载和初始化的
* 因为是在内部类加载和初始化是创建的，因此是线程安全的
* */
public class Singleton6 {

    private static Singleton6 instance;
    private Singleton6(){

    }

    private static class Inner {
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6 getInstance(){
        return Inner.INSTANCE;
    }
}
