package cn.my.test.sggp1.P3;


/*
* 父类的初始化 <client>
*  (1) j= method()
*  (2) 父类的静态代码块
*
*  * 父类的实例化方法：
 *  (1) super() 最前
 *  (2) i = test(); 非静态变量
 *  (3) 子类的非静态代码块
 *  (4) 子类的无参构造(最后)
 *
 *  非静态方法前面其实有一个默认的对象this
 *  this在构造器(或<init>) 它表示的是正在创建的对象，因为这里是在创建Son对象，所以
 *  test() 执行的是子类重写的代码（面向对象多态）
 *
 *  折扣i=test() 执行的是子类的重写test()方法
* */
public class Father {
    private int i = test();
    private static int j = method();

    static {
        System.out.println("(1) Father 静态代码块");
    }

    Father(){
        System.out.println("(2) Father 构造函数");
    }

    {
        System.out.println("(3) Father 非静态代码块");
    }

    public int test(){
        System.out.println("(4) Father 非静态方法");
        return 1;
    }

    public static int method(){
        System.out.println("(5) Farher 静态方法");
        return 1;
    }
}
