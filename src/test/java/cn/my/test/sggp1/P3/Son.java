package cn.my.test.sggp1.P3;

/**
 * The type Son.
 */
/*
 *  静态方法最先执行，然后是父类非静态方法，然后是构造器，然后是子类非静态方法，然后是子类构造器，
 *
 *  类初始化的过程
 *    一个类的创建实例需要先加载并初始化该类
 *       main 方法所在的类需要先加载和初始化
 *    一个子类要初始化需要先初始化父类
 *    一个类初始化就是执行 <client>() 方法
 *       <client>() 有静态类变量显示赋值代码和静态代码块组成
 *       类变量显示赋值代码和静态代码块从上到下顺序执行
 *       <client>() 方法只执行一次
 *  实例初始化过程
 *      <init>() 方法可能重载多个，有几个构造器就有几个<init>
         <init>()  方法有非静态实例变量显示赋值代码和非静态代码块、对应构造器代码组成
         非静态实例变量显示赋值代码和非静态代码块从上到下顺序执行，而对应构造器的代码最后执行
         每次创建实例对象，调用对应构造器，执行的就是对应的 <init>() 方法
          <init>() 方法的首行是super() 或者 super(实参列表)，即对应父类的<init>方法
 *  方法重写
 *    哪些方法不可以被重写
 *      final
 *      静态
 *      private 等子类中不可见方法
 *   对象的多态性
 *      子类如果重写了父类的方法，通过子类对象调用的一定是子类重写过的代码
 *      非静态方法默认的调用对象是this
 *      this 对象在构造器或者说<init>方法中就是正在创建的对象
 *
 *
 * */
/*
 *
 *   子类的初始化<client >
 *   (1) j = method
 *   (2) 子类的静态代码块
 *
 * 先初始化父类 (5) (1)
 *  初始化子类 (10)(6)
 *
 * 子类的实例化方法：
 *  (1) super() 最前 (9) (3) (2)
 *  (2) i = test(); 非静态变量 (9)
 *  (3) 子类的非静态代码块 (8)
 *  (4) 子类的无参构造(最后) (7)
 *
 *  因为创建了两个Son 对象，因此 实例化方法<init>执行两次
 *  9,3,2,9,8,7
 * */
public class Son extends Father {
    private int i = test();
    private static int j = method();

    static {
        System.out.println("(6) Son 静态代码块");
    }

    /**
     * Instantiates a new Son.
     */
    Son() {
        // super(); 写或不写都存在
        System.out.println("(7) Son 构造器");
    }

    {
        System.out.println("(8) Son 非静态代码块");
    }

    public int test() {
        System.out.println("(9) Son 非静态方法");
        return 1;
    }

    public int test2(){
        System.out.println("(12) Son 非静态方法2" );
        return 1;
    }

    /**
     * Method int.
     *
     * @return the int
     */
    public static int method() {
        System.out.println("(10) Son 静态方法");
        return 1;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println("=========");
        Son s2 = new Son();

        System.out.println("=========");
        s2.test();

        s2.test2();
    }
}
