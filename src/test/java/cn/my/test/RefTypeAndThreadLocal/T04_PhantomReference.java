package cn.my.test.RefTypeAndThreadLocal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

public class T04_PhantomReference {
   private static final List<Object> LIST  =new LinkedList<>();
   private static final ReferenceQueue<M> QUEUE  =new ReferenceQueue<>();

    public static void main(String[] args) {
        PhantomReference<M> phantomReference = new PhantomReference<>(new M(), QUEUE);
        // 对象 new M（） 被回收的时候，会被扔到 QUEUE 队列中
        // 队列检测到M(),检测是否指向堆外对象
        System.out.println(phantomReference.get()); // 虚引用get 不到

        new Thread(()->{
            while(true){
                LIST.add(new byte[1024*1024]);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                System.out.println(phantomReference.get());

            }
        }).start();

        // 模拟的垃圾回收线程，
        new Thread(()->{
            while (true){
                Reference<? extends M> poll = QUEUE.poll(); // 不断观察是否有引用放进去
                if(poll !=null){ // 有值说明有对象被回收，触发此方法，
                    System.out.println("----虚引用对象被JVM回收----" + poll);
                }

            }
        }).start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
   }
}
