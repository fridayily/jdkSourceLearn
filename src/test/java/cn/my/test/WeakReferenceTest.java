package cn.my.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;


class WeakReferenceTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void weakreference() {
        WeakReference<Card> weakCar = new WeakReference<>(new Card());
        Card card = new Card();
        System.out.println("弱引用对象 weakCar " + weakCar);
        System.out.println("弱引用对象get有值表示对象没有被回收 weakCar.get() " + weakCar.get());
        System.out.println("强引用对象car有值表示强引用存在 " + card);
        System.gc();
        System.out.println("弱引用GC后，弱引用对象被回收 weakCar.get() " + weakCar.get()); // gc 后有被回收
        System.out.println("强引用对象car没有回收 " + card); // gc 后没有被回收

    }

    @Test
    void weakreference2() {
        Card card = new Card();

        WeakReference<Card> weakCar = new WeakReference<>(new Card());
        int i = 0;

        while (true) {
            System.out.println("here is the strong reference 'car' " + card);//use the strong reference in the while loop
            if (weakCar.get() != null) {
                i++;
                System.out.println("Object is alive for " + i + " loops - " + weakCar);
            } else {
                System.out.println("Object has been collected.");
                break;
            }


        }
    }


    @Test
    void weakreference3() {
        Card card = new Card();
        WeakReference<Card> weakCar = new WeakReference<Card>(card);

        int i=0;

        while(true){
            if(weakCar.get()!=null){
                i++;
                System.out.println("Object is alive for "+i+" loops - "+weakCar);
            }else{
                System.out.println("Object has been collected.");
                break;
            }
        }
    }


    @Test
    void weakReferenceQueue() {
        // 这个ReferenceQueue的主要作用是存放那些已经被gc的reference
        ReferenceQueue<Card> referenceQueue = new ReferenceQueue<>();
        WeakReference<Card> weakCar = new WeakReference<>(new Card(), referenceQueue);
        System.out.println("weakCar=" + weakCar);
        System.out.println("weakCar.get()=" + weakCar.get());
        System.gc(); //告诉垃圾收集器打算进行垃圾收集，而垃圾收集器进不进行收集是不确定的
        System.runFinalization(); //强制调用已经失去引用的对象的finalize方法
        System.out.println("执行gc后 weakCar 被放入referenceQueue中  weakCar.get()=" + weakCar.get()); // gc 后有被回收
        System.out.println("弱引用队列存放了被销毁的 弱引用对象 " + referenceQueue.poll());
    }


}


class Car {
    String name;
    int age;

    public Car() {
        System.out.println("this is Car");
        this.name = "this is Car";
    }

    public Car(String name, int age) {
        this.name = name;
        this.age = age;
    }
}