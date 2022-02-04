package cn.my.test.RefTypeAndThreadLocal;

import java.io.IOException;

public class T01_NormalReference {
    public static void main(String[] args) throws IOException {
        M m = new M();  // 弱M 没有任何对象指向则是垃圾  m 位于栈里面，main结束则弹出去
        m = null;
        System.gc();
        System.out.println(m); // 主线程 和 Gc 线程哪个先执行是不确定的

        System.in.read(); // 阻塞main线程，给垃圾回收线程时间执行

    }
}
