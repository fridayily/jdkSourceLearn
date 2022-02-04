package cn.my.test.RefTypeAndThreadLocal;

import java.lang.ref.SoftReference;

public class T02_SoftReference {
    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024*1024*10]); // 10M  空间不够了软引用被回收
        System.out.println(m.get());
        System.gc();
        try{
            Thread.sleep(500);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(m.get()); // 软引用指向对象不能被回收

        // 再分配一个数组，heap将装不下，这时候系统会垃圾回收，先回收一次，如果不够，会把引用干掉
        byte[] b = new  byte[1024*1024*15]; // JVM参数 Xmx20M 配置JVM堆大小为20M
        System.out.println(m.get());
    }
}

// 软引用非常合适做缓存