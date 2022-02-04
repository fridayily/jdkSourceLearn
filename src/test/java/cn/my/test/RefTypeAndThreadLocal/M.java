package cn.my.test.RefTypeAndThreadLocal;

public class M {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize"); // 一个对象被回收时调用
    }

}

// 强引用指向对象 OOM 也不回收
// 软引用指向对象  空间不够 回收  缓存
// 弱引用指向对象  垃圾回收器看到 扫清
// 虚引用指向对象 给垃圾回收器一个消息，垃圾回收器收到后进行特殊处理