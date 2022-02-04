package cn.my.test.RefTypeAndThreadLocal;

import java.lang.ref.WeakReference;

public class T03_WeakReference {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());

        System.out.println(m.get()); // 一个M 没有强引用指向，只有弱引用指向，直接干掉M
        System.gc();
        System.out.println(m.get());

//        ThreadLocal<M> tl = new ThreadLocal<>();
//        tl.set(new M());
//        tl.remove();
    }
}
